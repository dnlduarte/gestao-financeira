package br.com.fiap.gestaofinanceira.pessoas.repository;

import br.com.fiap.gestaofinanceira.pessoas.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository
        extends JpaRepository<Endereco, String> {
}

