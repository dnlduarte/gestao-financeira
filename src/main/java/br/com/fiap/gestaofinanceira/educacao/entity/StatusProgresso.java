package br.com.fiap.gestaofinanceira.educacao.entity;

/**
 * Situação do usuário em um conteúdo educacional.
 */
public enum StatusProgresso {

    /** Usuário ainda não começou o conteúdo. */
    NAO_INICIADO,

    /** Usuário começou, mas ainda não terminou. */
    EM_ANDAMENTO,

    /** Usuário finalizou o conteúdo. */
    CONCLUIDO
}
