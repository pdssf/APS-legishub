package br.com.cin.aps.apjservice.controller

import br.com.cin.aps.apjservice.entity.Conta
import br.com.cin.aps.apjservice.entity.Contas
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController(val contas : Contas) {

    @PostMapping
    fun fazLogin(conta : Conta) : ResponseEntity<Boolean> {
        val contaFromCollection  = contas.buscaConta(conta.login)

        if(contaFromCollection != null){
            return if(contaFromCollection != null && conta.senha == contaFromCollection.senha) ResponseEntity.ok(true)
                   else ResponseEntity.badRequest().body(false)
        }
        return ResponseEntity.badRequest().body(false)
    }
}