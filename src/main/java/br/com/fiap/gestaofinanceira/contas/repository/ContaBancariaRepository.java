package br.com.fiap.gestaofinanceira.contas.repository;

import br.com.fiap.gestaofinanceira.contas.entity.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, String> {

    List<ContaBancaria> findByIdUsuario(String idUsuario);
}
