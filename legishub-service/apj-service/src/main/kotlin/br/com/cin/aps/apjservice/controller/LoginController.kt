package br.com.cin.aps.apjservice.controller

import br.com.cin.aps.apjservice.entity.Login
import br.com.cin.aps.apjservice.repository.LoginRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.print.attribute.standard.Media

@RestController
class LoginController(val repository: LoginRepository ) {


    @PostMapping(consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun createLogin(@RequestParam map: MultiValueMap<String, String>) = repository.save(Login(map.getFirst("login")!!,map.getFirst("password")!!));


    @PostMapping("/login", consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun login(@RequestParam map: MultiValueMap<String, String>): ResponseEntity<String>? {
        val loginFromRequest = map.getFirst("login")!!
        val passwordFromDb = repository.getPasswordByLogin(loginFromRequest)
        return when (passwordFromDb) {
            map.getFirst("password") -> ResponseEntity.ok("Login sucedido!")
            else -> ResponseEntity("Usuário ou senha incorretas", HttpStatus.FORBIDDEN)
        }
    }
    }


