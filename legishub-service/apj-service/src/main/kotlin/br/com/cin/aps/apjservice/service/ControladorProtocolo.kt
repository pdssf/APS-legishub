package br.com.cin.aps.apjservice.service

import br.com.cin.aps.apjservice.entity.Protocolo
import br.com.cin.aps.apjservice.repository.ProtocoloRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class ControladorProtocolo(
    val protocoloRepository: ProtocoloRepository, val walletService: ControladorWallet,
    @Value("\${protocols.price}")
    val valorProtocolo: Double
) {

    fun criarProtocolo(protocolo: Protocolo): ResponseEntity<String> {
        if (debitarValorProtocolo(protocolo.login)) {
            protocoloRepository.save(protocolo)
            return ResponseEntity.ok("Protocolo criado com sucesso!")
        }
        return ResponseEntity.badRequest().body("Erro ao criar protocolo: não foi possível debitar valor do cartão!");
    }

    private fun debitarValorProtocolo(login: String): Boolean {
        return walletService.debitarValor(login, valorProtocolo)
    }
}