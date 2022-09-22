package br.com.cin.aps.apjcardservice.service.card;

import br.com.cin.aps.apjcardservice.entity.Cartao;
import br.com.cin.aps.apjcardservice.dto.CardDTO;

public interface CardBrandService {

    boolean sendChargeRequest(Cartao cartao, Double valor) ;

    boolean sendValidationRequest(CardDTO cartao);
}
