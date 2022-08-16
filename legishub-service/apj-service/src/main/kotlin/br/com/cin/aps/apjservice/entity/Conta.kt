package br.com.cin.aps.apjservice.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Conta (
    @Column(name = "login_username")
    val login: String,
    @Column(name = "login_password")
    val senha: String
    ){
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}