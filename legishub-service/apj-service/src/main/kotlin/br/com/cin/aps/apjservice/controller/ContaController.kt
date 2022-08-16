package br.com.cin.aps.apjservice.controller

import br.com.cin.aps.apjservice.entity.Contas
import br.com.cin.aps.apjservice.entity.Conta
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ContaController(val contas: Contas) {



    @PostMapping(consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun criarConta(@RequestParam map: MultiValueMap<String, String>) : ResponseEntity<Conta> {

        val contaRequest = Conta(map.getFirst("login")!!,map.getFirst("password")!!)

        val contaExistente = checaContaExistente(contaRequest.login)
        val senhaReq = checaSenhaReq(contaRequest.senha)

        if(!contaExistente && senhaReq){
            contas.inserirConta(contaRequest)
            return ResponseEntity.ok(contaRequest)
        }

        return ResponseEntity.badRequest().build()


    }

    private fun checaContaExistente(login : String) = contas.checaContaExistente(login)


    private fun checaSenhaReq(senha : String) : Boolean = TODO()

    }


