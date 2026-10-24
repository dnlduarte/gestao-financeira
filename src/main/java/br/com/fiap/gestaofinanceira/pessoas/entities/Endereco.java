package br.com.fiap.gestaofinanceira.pessoas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_PES_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", length = 36, nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    @NotBlank
    @Size(min = 8, max = 8)
    @Column(name = "CEP", length = 8, nullable = false)
    private String cep;

    @NotBlank
    @Size(max = 150)
    @Column(name = "LOGRADOURO", length = 150, nullable = false)
    private String logradouro;

    @NotBlank
    @Size(max = 10)
    @Column(name = "NUMERO", length = 10, nullable = false)
    private String numero;

    @Size(max = 100)
    @Column(name = "COMPLEMENTO", length = 100)
    private String complemento;

    @Size(max = 100)
    @Column(name = "BAIRRO", length = 100)
    private String bairro;

    @NotBlank
    @Size(max = 100)
    @Column(name = "CIDADE", length = 100, nullable = false)
    private String cidade;

    @NotBlank
    @Size(min = 2, max = 2)
    @Column(name = "ESTADO", length = 2, nullable = false)
    private String estado;

    public Endereco() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}


