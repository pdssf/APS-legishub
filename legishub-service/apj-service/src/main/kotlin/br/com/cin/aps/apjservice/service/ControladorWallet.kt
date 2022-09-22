package br.com.cin.aps.apjservice.service

import br.com.cin.aps.apjservice.client.WalletRestClient
import br.com.cin.aps.apjservice.client.request.WalletRestServiceChargeRequest
import org.springframework.stereotype.Service
import feign.FeignException.BadRequest

@Service
class ControladorWallet (val walletRestClient: WalletRestClient) {

    fun debitarValor(login: String, valor: Double) : Boolean{
        val walletRestServiceRequest = buildRequest(login, valor)
        return try {
            val result = walletRestClient.chargeLogin(walletRestServiceRequest)
            true;
        } catch (e: BadRequest){
            false;
        }
    }

    private fun buildRequest(login: String, valor: Double) : WalletRestServiceChargeRequest = WalletRestServiceChargeRequest(login,valor)
}