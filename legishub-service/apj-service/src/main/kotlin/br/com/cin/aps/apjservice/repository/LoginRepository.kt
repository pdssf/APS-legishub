package br.com.cin.aps.apjservice.repository

import br.com.cin.aps.apjservice.entity.Login
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface LoginRepository : JpaRepository<Login, Long> {

    @Query(value = "select login_password from login where login_username=?1",nativeQuery = true)
    fun getPasswordByLogin(login: String) : String
}