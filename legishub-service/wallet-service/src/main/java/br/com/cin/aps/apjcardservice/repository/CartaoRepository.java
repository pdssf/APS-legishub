package br.com.cin.aps.apjcardservice.repository;

import br.com.cin.aps.apjcardservice.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    @Query("select count(c) from Cartao c where c.numero = ?1")
    int cartaoExiste(String numero);

    @Query("select c from Cartao c where c.loginUsuario = ?1")
    Optional<Cartao> findByLogin(String login);
}