package br.com.cin.aps.apjservice.controller

import br.com.cin.aps.apjservice.entity.Conta
import br.com.cin.aps.apjservice.entity.Contas
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class ControladorLogin(val contas : Contas) {



    @GetMapping("/login")
    fun criacaoConta() = ModelAndView("login/TelaLogin")

    @PostMapping("/fazLogin")
    fun fazLogin(conta: Conta) : ModelAndView {
        val contaFromCollection  = contas.buscarConta(conta.login)

            return if(contaFromCollection != null && conta.senha == contaFromCollection.senha) ModelAndView("app/Legishub")
                   else ModelAndView("login/TelaLogin").addObject("erroLogin","Login ou senha inválidos!")
    }





}