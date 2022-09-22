package br.com.cin.aps.apjcardservice.controller;

import br.com.cin.aps.apjcardservice.model.CardRegisterRequest;
import br.com.cin.aps.apjcardservice.model.LoginChargeRequest;
import br.com.cin.aps.apjcardservice.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class WalletController {

    @Autowired
    private CartaoService service;

    @PostMapping("/charges")
    public ResponseEntity<String> debitarValor(@RequestBody LoginChargeRequest request){
        return service.debitarValor(request);
    }

    @PostMapping("/cards")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> cadastrarCartao(@RequestBody CardRegisterRequest cartao) {
        return service.cadastrarCartao(cartao);
    }
}
