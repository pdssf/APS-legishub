package br.com.cin.aps.apjcardservice.service;

import br.com.cin.aps.apjcardservice.dto.CardDTO;
import br.com.cin.aps.apjcardservice.model.LoginChargeRequest;
import br.com.cin.aps.apjcardservice.model.CardRegisterRequest;
import br.com.cin.aps.apjcardservice.entity.Cartao;
import br.com.cin.aps.apjcardservice.factory.CardBrandServiceFactory;
import br.com.cin.aps.apjcardservice.repository.CartaoRepository;
import br.com.cin.aps.apjcardservice.service.card.CardBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    CartaoRepository repo;

   public ResponseEntity<String> cadastrarCartao(CardRegisterRequest dto) {
       CardDTO cardDTO = dto.getCard();

        if(repo.cartaoExiste( dto.getCard().getNumero()) > 0) return ResponseEntity.badRequest().body("Cartao ja esta cadastrado!");

        if(validarCartao(cardDTO)){
            repo.save(toEntity(dto));
            return ResponseEntity.ok("Cartao cadastrado!");
        }


        return ResponseEntity.badRequest().body("Cartao nao validado");
    }

    private Boolean validarCartao(CardDTO dto) {
        CardBrandService cardBrandService = CardBrandServiceFactory.createBrandService(dto.getBandeira());

        return cardBrandService.sendValidationRequest(dto);
    }

    public ResponseEntity<String> debitarValor(LoginChargeRequest request){
        Optional<Cartao> cartaoOp = repo.findByLogin(request.getLogin());

        if(cartaoOp.isEmpty()){
            return ResponseEntity.badRequest().body("Nao existe cartao vinculado a esse login!");
        }

        Cartao cartao = cartaoOp.get();

        CardBrandService cardBrandService = CardBrandServiceFactory.createBrandService(cartao.getBandeira());

        boolean chargeResult = cardBrandService.sendChargeRequest(cartao, request.getChargePrice());
        return chargeResult ?
                ResponseEntity.ok().body("Cobranca feita") :
                ResponseEntity.badRequest().body("Cobranca nao permitida pela operadora do cartao!");
    }

    private Cartao toEntity(CardRegisterRequest dtoRequest){
       CardDTO dto = dtoRequest.getCard();
       Cartao cartao = new Cartao();
       cartao.setBandeira(dto.getBandeira());
       cartao.setLoginUsuario(dtoRequest.getLoginUsuario());
       cartao.setNumero(dto.getNumero());
       cartao.setCodigo(dto.getCodigo());
       cartao.setValidade(dto.getValidade());
       return cartao;
    }
}
