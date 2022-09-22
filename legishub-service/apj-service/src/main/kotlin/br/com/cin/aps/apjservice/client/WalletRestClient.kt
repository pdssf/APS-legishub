package br.com.cin.aps.apjservice.client

import br.com.cin.aps.apjservice.client.request.WalletRestServiceChargeRequest
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "wallet", url = "http://wallet-server-service:8082/api/wallet")
interface WalletRestClient {

  @PostMapping("/charges")
  fun chargeLogin(@RequestBody walletRestServiceRequest: WalletRestServiceChargeRequest): String

}