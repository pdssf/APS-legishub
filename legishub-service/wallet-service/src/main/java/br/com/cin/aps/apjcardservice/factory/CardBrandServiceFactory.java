package br.com.cin.aps.apjcardservice.factory;

import br.com.cin.aps.apjcardservice.service.card.CardBrandService;
import br.com.cin.aps.apjcardservice.service.card.MastercardService;
import br.com.cin.aps.apjcardservice.service.card.VisaCardService;
import br.com.cin.aps.apjcardservice.entity.BandeiraCartao;

public class CardBrandServiceFactory {

    private CardBrandServiceFactory(){}

    public static CardBrandService createBrandService(BandeiraCartao bandeira){
        if(bandeira.equals(BandeiraCartao.VISA)){
            return new VisaCardService();
        }
        else if(bandeira.equals(BandeiraCartao.MASTERCARD)){
            return new MastercardService();
        }
        throw new RuntimeException("Bandeira não suportada");
    }
}
