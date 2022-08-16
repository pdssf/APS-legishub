package br.com.cin.aps.apjservice.client

import br.com.cin.aps.apjservice.entity.Cartao
import org.springframework.stereotype.Component

class CardBrand2Service : CardBrandService {

    override fun validar(cartao : Cartao) : Boolean = TODO("Invoking external service")

    override fun debitar(cartao : Cartao, valor : Int) : Int = TODO("Invoking external service - debitar valor no cartão")


}