package br.com.cin.aps.apjservice.client;

import br.com.cin.aps.apjservice.entity.Cartao
import org.springframework.stereotype.Service

@Service
interface CardBrandService {
     fun validar(cartao : Cartao) : Boolean
     fun debitar(cartao : Cartao, valor : Int) : Int
}
