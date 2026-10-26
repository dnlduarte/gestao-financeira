package br.com.fiap.gestaofinanceira.contas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Chave Pix vinculada a uma conta. O valor da chave e unico no sistema.
 */
@Entity
@Table(name = "TB_CTA_CHAVE_PIX")
@Getter
@Setter
@NoArgsConstructor
public class ChavePix {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", length = 36)
    private String id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CONTA", nullable = false)
    private ContaBancaria conta;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false, length = 20)
    private TipoChavePix tipo;

    @NotBlank
    @Size(max = 77)
    @Column(name = "VALOR", nullable = false, length = 77)
    private String valor;

    @NotNull
    @Column(name = "ATIVA", nullable = false)
    private Boolean ativa = Boolean.TRUE;

    @Column(name = "CRIADO_EM", nullable = false, insertable = false, updatable = false)
    private LocalDateTime criadoEm;
}
