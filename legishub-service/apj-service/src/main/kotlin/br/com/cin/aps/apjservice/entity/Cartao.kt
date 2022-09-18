package br.com.cin.aps.apjservice.entity

import java.math.BigInteger
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Cartao(@Column val bandeira : BandeiraCartao,
                  @Column val numero : BigInteger,
                  @Column val codigo: Int,
                  @Column val validade: Int) {
    @Id val id: Long? = null

}

class CreditCardBuilder{
    private var bandeira : BandeiraCartao? = null
    private var number : BigInteger? = null
    private var code: Int? = null
    private var validade: Int? = null

     fun flag(creditCardFlag: BandeiraCartao) : CreditCardBuilder{ bandeira = creditCardFlag ; return this}

     fun number(number: BigInteger) : CreditCardBuilder{ this.number=number ; return this}

     fun code(code: Int) : CreditCardBuilder{ this.code=code ; return this}
    fun validade(validade: Int) : CreditCardBuilder { this.validade=validade ; return this}

     fun build() : Cartao = Cartao(bandeira!!,number!!,code!!, validade!!)


}




enum class BandeiraCartao{
    VISA,MASTERCARD
}
