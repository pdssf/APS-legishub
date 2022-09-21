package br.com.cin.aps.apjservice.controller


import br.com.cin.aps.apjservice.service.ControladorLogin
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/loginSessions")
class LoginController(val service: ControladorLogin) {


    @PostMapping
    fun armazenaSessao(token: String) : ResponseEntity<String> = service.armazenaSessao(token)






}