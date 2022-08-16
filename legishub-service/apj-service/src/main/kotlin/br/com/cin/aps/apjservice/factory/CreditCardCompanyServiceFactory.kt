package br.com.cin.aps.apjservice.factory

import br.com.cin.aps.apjservice.client.CardBrand1Service
import br.com.cin.aps.apjservice.client.CardBrand2Service
import br.com.cin.aps.apjservice.client.CardBrandService
import br.com.cin.aps.apjservice.entity.BandeiraCartao

object CreditCardCompanyServiceFactory {
    fun createService(bandeira : BandeiraCartao) : CardBrandService{
       return when(bandeira.name){
            BandeiraCartao.VISA.name -> CardBrand1Service()
            else -> CardBrand2Service()
        }
    }
}