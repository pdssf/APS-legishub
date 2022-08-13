package br.com.cin.aps.apjservice.client;

import org.springframework.stereotype.Service

@Service
interface CardBrandService {
     fun validateCreditCard(ex : String) : Boolean
}
