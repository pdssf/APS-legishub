package br.com.cin.aps.apjservice.subsistemacartao

import br.com.cin.aps.apjservice.entity.Cartao


class ComunicacaoCartaoBandeira2 : ISubsistemaComunicacaoCartao {

    override fun validar(cartao : Cartao) : Boolean = true //Validando cartão na operadora 2

    override fun debitar(cartao : Cartao, valor : Int) : Int = TODO("Enviando requisição para a operadora 2 debitar valor no cartão")

}