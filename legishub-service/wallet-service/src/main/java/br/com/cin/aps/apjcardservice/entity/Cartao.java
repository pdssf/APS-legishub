package br.com.cin.aps.apjcardservice.entity;

import javax.persistence.*;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "login_usuario")
    String loginUsuario;

    @Column
    @Enumerated
    BandeiraCartao bandeira;

    @Column
    String numero;

    @Column
    int codigo;

    @Column
    int validade;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getLoginUsuario() {return loginUsuario;}

    public void setLoginUsuario(String loginUsuario) {this.loginUsuario = loginUsuario;}

    public BandeiraCartao getBandeira() {
        return bandeira;
    }

    public void setBandeira(BandeiraCartao cartao) {
        this.bandeira = cartao;
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

