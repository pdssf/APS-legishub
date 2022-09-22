package br.com.cin.aps.apjservice.controller


import br.com.cin.aps.apjservice.service.ControladorLogin
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/loginSessions")
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
class LoginController(val service: ControladorLogin) {


    @PostMapping
    fun armazenaSessao(@RequestBody token: String) : ResponseEntity<String> = service.armazenaSessao(token)






}