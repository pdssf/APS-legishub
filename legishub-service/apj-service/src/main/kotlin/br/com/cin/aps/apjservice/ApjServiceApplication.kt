package br.com.cin.aps.apjservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ApjServiceApplication

fun main(args: Array<String>) {
	runApplication<ApjServiceApplication>(*args)
}
