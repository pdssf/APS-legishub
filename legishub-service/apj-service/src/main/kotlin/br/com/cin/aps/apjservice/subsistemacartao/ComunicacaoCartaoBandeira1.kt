package br.com.cin.aps.apjservice.subsistemacartao

import br.com.cin.aps.apjservice.entity.Cartao

class ComunicacaoCartaoBandeira1 : ISubsistemaComunicacaoCartao {

    override fun validar(cartao : Cartao) : Boolean = true //Validando cartão na operadora 1

    override fun debitar(cartao : Cartao, valor : Int) : Int = TODO("Enviando requisição para a operadora 2 debitar valor no cartão")


}