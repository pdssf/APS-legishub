package br.com.cin.aps.apjservice.entity

import java.math.BigInteger
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CreditCard(@Column private val flag : CreditCardFlag,
                 @Column  private val number : BigInteger,
                 @Column private val code: Int) {
    @Id val id: Long? = null
    fun getFlag() = flag
}

class CreditCardBuilder{
    private var flag : CreditCardFlag? = null
    private var number : BigInteger? = null
    private var code: Int? = null

     fun flag(creditCardFlag: CreditCardFlag) : CreditCardBuilder{ flag = creditCardFlag ; return this}

     fun number(number: BigInteger) : CreditCardBuilder{ this.number=number ; return this}

     fun code(code: Int) : CreditCardBuilder{ this.code=code ; return this}

     fun build() : CreditCard = CreditCard(flag!!,number!!,code!!)


}


enum class CreditCardFlag{
    VISA,MASTERCARD
}
