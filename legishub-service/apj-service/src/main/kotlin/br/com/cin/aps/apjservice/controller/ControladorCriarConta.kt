package br.com.cin.aps.apjservice.controller

import br.com.cin.aps.apjservice.entity.Contas
import br.com.cin.aps.apjservice.entity.Conta
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class ControladorCriarConta(val contas: Contas) {


    @GetMapping("/criacaoConta")
    fun criacaoConta() = ModelAndView("conta/TelaCriarConta")

    @PostMapping("/criarConta")
    fun criarConta(conta: Conta): ModelAndView {

        if (checaContaExistente(conta.login))
            return ModelAndView("conta/TelaCriarConta").addObject("erroCriacao", "E-mail já está cadastrado no sistema")
        if (!checaSenhaReq(conta.senha))
            return ModelAndView("conta/TelaCriarConta").addObject("erroCriacao", "A senha deve conter no mínimo 8 caracteres e um número")
        contas.inserirConta(conta)
        return ModelAndView("conta/ContaCriadaComSucesso")
    }



private fun checaContaExistente(login: String) = contas.checaContaExistente(login)


private fun checaSenhaReq(senha: String) = senha.length >= 8 && senha.contains(Regex("[0-9]"))


}


