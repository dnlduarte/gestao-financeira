package br.com.fiap.gestaofinanceira.educacao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Conteúdo educacional do tipo artigo, escrito por um autor.
 */
@Entity
@DiscriminatorValue("ARTIGO")
@Getter
@Setter
@NoArgsConstructor
public class Artigo extends ConteudoEducacional {

    /** Nome do autor do artigo. */
    @NotBlank(message = "O autor do artigo é obrigatório")
    @Size(max = 100, message = "O autor deve ter no máximo 100 caracteres")
    @Column(name = "AUTOR", length = 100)
    private String autor;

    /** Retorna uma descrição do artigo com o nome do autor. */
    @Override
    public String exibirDetalhes() {
        return "Artigo escrito por " + autor;
    }

    /** Atualiza o autor com os dados do artigo recebido. */
    @Override
    public void atualizarDadosEspecificos(ConteudoEducacional dados) {
        this.autor = ((Artigo) dados).getAutor();
    }
}
