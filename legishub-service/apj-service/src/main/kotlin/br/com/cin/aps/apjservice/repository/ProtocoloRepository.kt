package br.com.cin.aps.apjservice.repository

import br.com.cin.aps.apjservice.entity.Protocolo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface ProtocoloRepository : JpaRepository<Protocolo, Long>{

}