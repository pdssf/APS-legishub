package br.com.cin.aps.apjservice.controller

import br.com.cin.aps.apjservice.entity.BandeiraCartao
import br.com.cin.aps.apjservice.entity.Cartao
import br.com.cin.aps.apjservice.entity.Cartoes
import br.com.cin.aps.apjservice.factory.CreditCardCompanyServiceFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView
import java.math.BigInteger

@Controller
class ControladorCriarCartao(val cartoes: Cartoes) {



    @GetMapping("criacaoCartao")
    fun criacaoCartao() = ModelAndView("cartao/TelaCriarCartao")


    @PostMapping("/cadastrarCartao")
    fun cadastrarCartao(cartao: Cartao) : ModelAndView {

        val cardBrandService = CreditCardCompanyServiceFactory.createService(cartao.bandeira)

        if(cardBrandService.validar(cartao)) {
            return if (cartoes.inserir(cartao) == cartao.codigo) {
                ModelAndView("app/Legishub") }
            else { ModelAndView("app/Legishub") }
        }

       return ModelAndView("/cartao/TelaCriarCartao").addObject("erroCriacao", "Cartão inválido!")

    }

}