package br.com.cin.aps.apjservice.controller

import br.com.cin.aps.apjservice.entity.Cartao
import br.com.cin.aps.apjservice.entity.Cartoes
import br.com.cin.aps.apjservice.factory.CreditCardCompanyServiceFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CreditCardController(val cartoes: Cartoes) {



    @PostMapping
    fun cadastrarCartao(cartao: Cartao) : ResponseEntity<Boolean>{

        val cardBrandService = CreditCardCompanyServiceFactory.createService(cartao.bandeira)

        if(cardBrandService.validar(cartao)) {
            return if (cartoes.inserir(cartao) == cartao.codigo) { ResponseEntity.ok().body(true) }
                   else { ResponseEntity.badRequest().body(false) }
        }

       return ResponseEntity.badRequest().body(false)

    }

}