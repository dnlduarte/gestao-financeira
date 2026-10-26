package br.com.fiap.gestaofinanceira.contas.repository;

import br.com.fiap.gestaofinanceira.contas.entity.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BancoRepository extends JpaRepository<Banco, String> {

    Optional<Banco> findByCodigo(String codigo);
}
