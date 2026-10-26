package br.com.fiap.gestaofinanceira.contas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Instituicao financeira onde a conta e mantida, identificada pelo codigo COMPE.
 */
@Entity
@Table(name = "TB_CTA_BANCO")
@Getter
@Setter
@NoArgsConstructor
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", length = 36)
    private String id;

    @NotBlank
    @Pattern(regexp = "\\d{3}", message = "deve ter 3 digitos")
    @Column(name = "CODIGO", nullable = false, length = 3)
    private String codigo;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;
}
