package br.com.cin.aps.apjservice.entity

import javax.persistence.*

@Entity
data class Sessao (@Column(length = 1000)val token: String,
                   @Id
                   @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null
)