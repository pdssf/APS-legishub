package br.com.cin.aps.apjservice.entity

import javax.persistence.*

@Entity
data class Sessao (val token: String,
                   @Id
                   @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null
)