package br.com.cin.aps.apjservice.factory

import br.com.cin.aps.apjservice.client.CardBrand1Service
import br.com.cin.aps.apjservice.client.CardBrand2Service
import br.com.cin.aps.apjservice.client.CardBrandService
import br.com.cin.aps.apjservice.entity.CreditCardFlag

object CreditCardCompanyServiceFactory {
    fun createService(flag : CreditCardFlag) : CardBrandService{
       return when(flag.name){
            CreditCardFlag.VISA.name -> CardBrand1Service()
            else -> CardBrand2Service()
        }
    }
}