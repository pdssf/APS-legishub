package br.com.cin.aps.apjservice.controller

import br.com.cin.aps.apjservice.entity.Protocolo
import br.com.cin.aps.apjservice.service.ControladorProtocolo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/protocols")
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
class ProtocoloController(val service: ControladorProtocolo) {

    @PostMapping
    fun criarProtocolo(@RequestBody protocolo: Protocolo) : ResponseEntity<String> = service.criarProtocolo(protocolo)

    


}