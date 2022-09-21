package br.com.cin.aps.apjservice.controller

import br.com.cin.aps.apjservice.entity.Protocolo
import br.com.cin.aps.apjservice.service.ControladorProtocolo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/protocols")
class ProtocoloController(val service: ControladorProtocolo) {

    @PostMapping
    fun criarProtocolo(@RequestBody protocolo: Protocolo) : ResponseEntity<String> = service.criarProtocolo(protocolo)

    


}