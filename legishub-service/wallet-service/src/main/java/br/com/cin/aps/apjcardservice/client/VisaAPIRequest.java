package br.com.cin.aps.apjcardservice.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisaAPIRequest {

    @JsonProperty("chosen_type")
    String type;


    @JsonProperty("card_number")
    String cardNumber;


    @JsonProperty("scode")
    int code;


    @JsonProperty("v_year")
    int valid;

    @JsonProperty("amount")
    Double amount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public static VisaAPIRequest.VisaRequestBuilder builder(){
        return new VisaAPIRequest.VisaRequestBuilder();
    }

    public static class VisaRequestBuilder{

        String type;
        String cardNumber;
        int code;
        int valid;
        Double amount;

        public VisaAPIRequest.VisaRequestBuilder type(String type) {
            this.type = type;
            return this;
        }

        public VisaAPIRequest.VisaRequestBuilder cardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public VisaAPIRequest.VisaRequestBuilder code(int code) {
            this.code = code;
            return this;
        }

        public VisaAPIRequest.VisaRequestBuilder valid(int valid) {
            this.valid = valid;
            return this;
        }

        public VisaAPIRequest.VisaRequestBuilder chargeAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public VisaAPIRequest build(){
            VisaAPIRequest request = new VisaAPIRequest();
            request.setType(this.type);
            request.setCardNumber(this.cardNumber);
            request.setCode(this.code);
            request.setValid(this.valid);
            request.setAmount(this.amount);
            return request;
        }
    }
}