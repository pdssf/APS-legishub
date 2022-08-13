package br.com.cin.aps.apjservice.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
data class Login (
    @Column(name = "login_username")
    val login: String,
    @Column(name = "login_password")
    val password: String
    ){
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}