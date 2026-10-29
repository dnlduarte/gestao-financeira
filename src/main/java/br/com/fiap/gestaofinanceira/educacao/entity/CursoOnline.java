package br.com.fiap.gestaofinanceira.educacao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Conteúdo educacional do tipo curso online, composto por módulos.
 */
@Entity
@DiscriminatorValue("CURSO")
@Getter
@Setter
@NoArgsConstructor
public class CursoOnline extends ConteudoEducacional {

    /** Quantidade de módulos do curso. */
    @NotNull(message = "O número de módulos do curso é obrigatório")
    @Positive(message = "O curso deve ter pelo menos 1 módulo")
    @Max(value = 100, message = "O curso pode ter no máximo 100 módulos")
    @Column(name = "NUMERO_MODULOS")
    private Integer numeroModulos;

    /** Retorna uma descrição do curso com o número de módulos. */
    @Override
    public String exibirDetalhes() {
        return "Curso online com " + numeroModulos + " módulo(s)";
    }

    /** Atualiza o número de módulos com os dados do curso recebido. */
    @Override
    public void atualizarDadosEspecificos(ConteudoEducacional dados) {
        this.numeroModulos = ((CursoOnline) dados).getNumeroModulos();
    }
}
