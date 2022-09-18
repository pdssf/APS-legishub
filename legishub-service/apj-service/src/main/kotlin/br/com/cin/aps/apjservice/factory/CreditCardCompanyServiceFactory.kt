package br.com.cin.aps.apjservice.factory

import br.com.cin.aps.apjservice.subsistemacartao.ISubsistemaComunicacaoCartao
import br.com.cin.aps.apjservice.subsistemacartao.ComunicacaoCartaoBandeira1
import br.com.cin.aps.apjservice.subsistemacartao.ComunicacaoCartaoBandeira2
import br.com.cin.aps.apjservice.entity.BandeiraCartao

object CreditCardCompanyServiceFactory {
    fun createService(bandeira: BandeiraCartao): ISubsistemaComunicacaoCartao {
        return when (bandeira) {
            BandeiraCartao.VISA -> ComunicacaoCartaoBandeira1()
            else -> ComunicacaoCartaoBandeira2()
        }
    }
}
