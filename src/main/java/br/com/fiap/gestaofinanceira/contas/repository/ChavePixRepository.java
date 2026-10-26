package br.com.fiap.gestaofinanceira.contas.repository;

import br.com.fiap.gestaofinanceira.contas.entity.ChavePix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChavePixRepository extends JpaRepository<ChavePix, String> {

    Optional<ChavePix> findByValor(String valor);

    List<ChavePix> findByContaId(String idConta);
}
