package br.com.cin.aps.apjservice.service

import br.com.cin.aps.apjservice.entity.CreditCardBuilder
import br.com.cin.aps.apjservice.entity.CreditCardFlag
import br.com.cin.aps.apjservice.factory.CreditCardCompanyServiceFactory
import br.com.cin.aps.apjservice.repository.CreditCardRepository
import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class CreditCardService(val repo: CreditCardRepository) {

    fun storeCreditCard(ex : String){
        val card = CreditCardBuilder()
                .code(312)
                .flag(CreditCardFlag.VISA)
                .number(BigInteger("321321"))
                .build()

        val externalService = CreditCardCompanyServiceFactory.createService(card.getFlag())

        if(externalService.validateCreditCard("ex")) {
            repo.save(card)
        }

    }
}