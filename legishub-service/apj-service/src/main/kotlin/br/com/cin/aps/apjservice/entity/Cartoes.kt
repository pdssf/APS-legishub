package br.com.cin.aps.apjservice.entity

import org.springframework.stereotype.Component
import java.math.BigInteger


@Component
class Cartoes(val cartoes  : MutableList<Cartao> = mutableListOf()){


    fun buscar(bandeira: BandeiraCartao, numero : BigInteger) : Cartao = cartoes.first { c -> c.bandeira == bandeira && c.numero==numero }

    fun inserir(cartao: Cartao) : Int = if(cartoes.add(cartao)) {cartao.codigo}  else {0}

}


