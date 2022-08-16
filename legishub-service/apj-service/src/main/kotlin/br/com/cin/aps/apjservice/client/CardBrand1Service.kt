package br.com.cin.aps.apjservice.client

import br.com.cin.aps.apjservice.entity.Cartao


class CardBrand1Service : CardBrandService {

    override fun validar(cartao : Cartao) : Boolean  = TODO("Invoking external service")


    override fun debitar(cartao : Cartao, valor : Int) : Int = TODO("Invoking external service - debitar valor no cartão")

}