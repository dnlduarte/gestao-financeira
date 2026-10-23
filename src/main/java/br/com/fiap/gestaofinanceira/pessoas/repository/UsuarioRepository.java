package br.com.fiap.gestaofinanceira.pessoas.repository;

import br.com.fiap.gestaofinanceira.pessoas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository
        extends JpaRepository<Usuario, String> {
}

