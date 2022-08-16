package br.com.cin.aps.apjservice.entity

import java.math.BigInteger
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Cartao(@Column val bandeira : BandeiraCartao,
                  @Column val numero : BigInteger,
                  @Column val codigo: Int) {
    @Id val id: Long? = null

}

class CreditCardBuilder{
    private var bandeira : BandeiraCartao? = null
    private var number : BigInteger? = null
    private var code: Int? = null

     fun flag(creditCardFlag: BandeiraCartao) : CreditCardBuilder{ bandeira = creditCardFlag ; return this}

     fun number(number: BigInteger) : CreditCardBuilder{ this.number=number ; return this}

     fun code(code: Int) : CreditCardBuilder{ this.code=code ; return this}

     fun build() : Cartao = Cartao(bandeira!!,number!!,code!!)


}


enum class BandeiraCartao{
    VISA,MASTERCARD
}
