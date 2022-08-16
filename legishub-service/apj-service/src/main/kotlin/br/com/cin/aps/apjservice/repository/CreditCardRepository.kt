package br.com.cin.aps.apjservice.repository

import br.com.cin.aps.apjservice.entity.Cartao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditCardRepository : JpaRepository<Cartao, Long> {
}