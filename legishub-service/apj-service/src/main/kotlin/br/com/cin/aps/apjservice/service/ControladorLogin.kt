package br.com.cin.aps.apjservice.service

import br.com.cin.aps.apjservice.entity.Sessao
import br.com.cin.aps.apjservice.repository.SessionRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ControladorLogin(val repo: SessionRepository) {

    fun armazenaSessao(token: String) : ResponseEntity<String>  {
        val sessionSaved = repo.save(Sessao(token))
        return ResponseEntity.ok("Session stored!")
    }
}