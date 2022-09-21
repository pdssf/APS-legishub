package br.com.cin.aps.apjcardservice.service.card;

import br.com.cin.aps.apjcardservice.client.MastercardAPIRequest;
import br.com.cin.aps.apjcardservice.entity.Cartao;
import br.com.cin.aps.apjcardservice.dto.CardDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class MastercardService implements CardBrandService {

    ObjectMapper mapper = new ObjectMapper();

    private final String masterCardAPIUrl = "http://ec2-100-24-52-130.compute-1.amazonaws.com:8080/mastercard";



    @Override
    public boolean sendChargeRequest(Cartao cartao, Double valor) {

        MastercardAPIRequest request = MastercardAPIRequest.builder()
                .cardNumber(cartao.getNumero())
                .code(cartao.getCodigo())
                .valid(cartao.getValidade())
                .chargeAmount(valor)
                .build();


        try{
            String json = mapper.writeValueAsString(request);
            HttpRequest requestHttp = HttpRequest
                    .newBuilder(URI.create(masterCardAPIUrl + "/charges"))
                    .header("Content-Type", "application/json")
                    .POST(bodyRequest(json))
                    .build();

            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(requestHttp, HttpResponse.BodyHandlers.ofString());

            return response.body().equals("CHARGE_OK");
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean sendValidationRequest(CardDTO cartao) {
        MastercardAPIRequest request = MastercardAPIRequest.builder()
                .cardNumber(cartao.getNumero())
                .code(cartao.getCodigo())
                .valid(cartao.getValidade())
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();

            String jsonRequestBody = mapper.writeValueAsString(request);
            HttpRequest requestHttp = HttpRequest
                    .newBuilder(URI.create(masterCardAPIUrl + "/validations"))
                    .POST(bodyRequest(jsonRequestBody))
                    .header("Content-Type","application/json")
                    .build();

            String response = client
                    .send(requestHttp, HttpResponse.BodyHandlers.ofString())
                    .body();

            return response.equals("CARD_VALID");
        }
        catch (Exception e){
            return false;
        }


    }

    public HttpRequest.BodyPublisher bodyRequest(String json){
        return HttpRequest.BodyPublishers.ofString(json);
    }
}
