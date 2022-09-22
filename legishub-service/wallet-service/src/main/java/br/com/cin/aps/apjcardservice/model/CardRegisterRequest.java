package br.com.cin.aps.apjcardservice.model;

import br.com.cin.aps.apjcardservice.dto.CardDTO;
import com.fasterxml.jackson.annotation.JsonProperty;


public class CardRegisterRequest {
    @JsonProperty("login")
    String loginUsuario;

    CardDTO card;

    public String getLoginUsuario() {return loginUsuario;}

    public void setLoginUsuario(String loginUsuario) {this.loginUsuario = loginUsuario;}

    public CardDTO getCard() {
        return card;
    }

    public void setCard(CardDTO card) {
        this.card = card;
    }
}


