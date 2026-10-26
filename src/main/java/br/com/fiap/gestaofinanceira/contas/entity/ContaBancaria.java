package br.com.fiap.gestaofinanceira.contas.entity;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Conta bancaria do usuario. Uma unica classe com o campo {@code tipo}
 * (CORRENTE ou POUPANCA): o limite de cheque especial so vale para corrente
 * e a taxa de rendimento so para poupanca.
 */
@Entity
@Table(name = "TB_CTA_CONTA")
@Getter
@Setter
@NoArgsConstructor
public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", length = 36)
    private String id;

    // Titular: TB_PES_USUARIO do modulo 01. Outro modulo -> so o id.
    @NotBlank
    @Size(max = 36)
    @Column(name = "ID_USUARIO", nullable = false, length = 36)
    private String idUsuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_BANCO", nullable = false)
    private Banco banco;

    @NotBlank
    @Size(max = 20)
    @Column(name = "NUMERO_CONTA", nullable = false, length = 20)
    private String numeroConta;

    @NotBlank
    @Size(max = 10)
    @Column(name = "AGENCIA", nullable = false, length = 10)
    private String agencia;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false, length = 20)
    private TipoConta tipo;

    @NotNull
    @Column(name = "SALDO", nullable = false, precision = 15, scale = 2)
    private BigDecimal saldo = BigDecimal.ZERO;

    @PositiveOrZero
    @Column(name = "LIMITE_CHEQUE_ESPECIAL", precision = 15, scale = 2)
    private BigDecimal limiteChequeEspecial;

    @DecimalMin("0.00")
    @Column(name = "TAXA_RENDIMENTO_MENSAL", precision = 5, scale = 2)
    private BigDecimal taxaRendimentoMensal;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 20)
    private StatusConta status = StatusConta.ATIVA;

    @NotNull
    @PastOrPresent
    @Column(name = "DATA_ABERTURA", nullable = false)
    private LocalDate dataAbertura;

    @Column(name = "DATA_ENCERRAMENTO")
    private LocalDate dataEncerramento;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChavePix> chavesPix = new ArrayList<>();
}
