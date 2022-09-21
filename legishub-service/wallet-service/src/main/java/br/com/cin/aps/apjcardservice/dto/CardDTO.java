package br.com.cin.aps.apjcardservice.dto;

import br.com.cin.aps.apjcardservice.entity.BandeiraCartao;

public class CardDTO {

    BandeiraCartao bandeira;

    String numero;

    int codigo;

    int validade;

    public BandeiraCartao getBandeira() {
        return bandeira;
    }

    public void setBandeira(BandeiraCartao bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }
}
