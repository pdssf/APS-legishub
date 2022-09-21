package br.com.cin.aps.apjservice.entity

import javax.persistence.*


@Entity
data class Protocolo(
    @Column val numeroCnj: String,

    @Column
    @Lob
    val arquivo: Array<Byte>,

    @Column
    val login: String,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
)