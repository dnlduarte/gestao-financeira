package br.com.fiap.gestaofinanceira.transacoes.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.gestaofinanceira.transacoes.entites.TipoTransacao;
import br.com.fiap.gestaofinanceira.transacoes.entites.Transacao;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {

    List<Transacao> findByTipoOrderByDataTransacao(TipoTransacao tipo);

    List<Transacao> findByIdPessoa(String idPessoa);
}
