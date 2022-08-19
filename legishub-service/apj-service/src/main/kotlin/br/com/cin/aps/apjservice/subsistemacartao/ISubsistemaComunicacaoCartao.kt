package br.com.cin.aps.apjservice.subsistemacartao;

import br.com.cin.aps.apjservice.entity.Cartao
import org.springframework.stereotype.Service

@Service
interface ISubsistemaComunicacaoCartao {
     fun validar(cartao : Cartao) : Boolean
     fun debitar(cartao : Cartao, valor : Int) : Int
}
