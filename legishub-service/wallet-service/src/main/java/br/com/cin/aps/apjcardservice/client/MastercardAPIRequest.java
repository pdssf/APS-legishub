package br.com.cin.aps.apjcardservice.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MastercardAPIRequest {
    @JsonProperty("cc_number")
    String cardNumber;


    @JsonProperty("sec_code")
    int code;


    @JsonProperty("v_date_y")
    int valid;

    @JsonProperty("charge_amount")
    Double amount;

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

    public static MastercardRequestBuilder builder(){
        return new MastercardRequestBuilder();
    }

    public static class MastercardRequestBuilder{
        String cardNumber;
        int code;
        int valid;
        Double amount;

        public MastercardRequestBuilder cardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public MastercardRequestBuilder code(int code) {
            this.code = code;
            return this;
        }

        public MastercardRequestBuilder valid(int valid) {
            this.valid = valid;
            return this;
        }

        public MastercardRequestBuilder chargeAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public MastercardAPIRequest build(){
            MastercardAPIRequest request = new MastercardAPIRequest();
            request.setCardNumber(this.cardNumber);
            request.setCode(this.code);
            request.setValid(this.valid);
            request.setAmount(this.amount);
            return request;
        }
    }
}
