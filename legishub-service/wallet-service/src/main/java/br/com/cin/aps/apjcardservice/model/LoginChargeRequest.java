package br.com.cin.aps.apjcardservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginChargeRequest {

    String login;
    @JsonProperty("charge_price")
    Double chargePrice;

    public String getLogin() {
        return login;
    }

    public void setLogin(String card) {
        this.login = card;
    }

    public Double getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(Double chargePrice) {
        this.chargePrice = chargePrice;
    }
}
