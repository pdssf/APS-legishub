package br.com.cin.aps.apjservice.entity

import org.springframework.stereotype.Component

@Component
class Contas(val contas : MutableList<Conta> = mutableListOf()) {


    fun buscaConta(login : String) = contas.firstOrNull { c -> c.login == login }

    fun checaContaExistente(login : String) = contas.any { c -> c.login == login }

    fun inserirConta(conta : Conta) = contas.add(conta)
}