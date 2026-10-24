package br.com.fiap.gestaofinanceira.pessoas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_PES_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", length = 36, nullable = false)
    private String id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @NotBlank
    @Size(min = 11, max = 11)
    @Column(name = "CPF", length = 11, nullable = false, unique = true)
    private String cpf;

    @Email
    @Size(max = 150)
    @Column(name = "EMAIL", length = 150)
    private String email;

    @Size(max = 20)
    @Column(name = "TELEFONE", length = 20)
    private String telefone;

    @OneToMany(
            mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Endereco> enderecos = new ArrayList<>();

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}

