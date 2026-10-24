-- =====================================================================
-- 02-contas.sql - Modulo 02 - Contas Bancarias
-- Prefixo das tabelas: TB_CTA_
-- Criado pelo professor na integracao da Entrega 3: o grupo de Contas
-- ainda nao entregou o script e o modulo 05 (Dividas) depende de
-- TB_CTA_CONTA. O grupo pode evoluir este arquivo nas proximas entregas.
-- ID_USUARIO referencia TB_PES_USUARIO (modulo 01).
-- Os IDs recebem o UUID gerado pela aplicacao.
-- =====================================================================

CREATE TABLE TB_CTA_CONTA (
    ID                      VARCHAR2(36)   NOT NULL,
    ID_USUARIO              VARCHAR2(36)   NOT NULL,
    NUMERO_CONTA            VARCHAR2(20)   NOT NULL,
    AGENCIA                 VARCHAR2(10)   NOT NULL,
    TIPO                    VARCHAR2(20)   NOT NULL,
    SALDO                   NUMBER(15,2)   DEFAULT 0 NOT NULL,
    LIMITE_CHEQUE_ESPECIAL  NUMBER(15,2),
    TAXA_RENDIMENTO_MENSAL  NUMBER(5,2),
    STATUS                  VARCHAR2(20)   DEFAULT 'ATIVA' NOT NULL,
    DATA_ABERTURA           DATE           NOT NULL,
    DATA_ENCERRAMENTO       DATE,
    CONSTRAINT PK_CTA_CONTA PRIMARY KEY (ID),
    CONSTRAINT UK_CTA_CONTA_NUMERO UNIQUE (AGENCIA, NUMERO_CONTA),
    CONSTRAINT FK_CTA_CONTA_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES TB_PES_USUARIO (ID),
    CONSTRAINT CK_CTA_CONTA_TIPO CHECK (TIPO IN ('CORRENTE', 'POUPANCA')),
    CONSTRAINT CK_CTA_CONTA_STATUS CHECK (STATUS IN ('ATIVA', 'BLOQUEADA', 'ENCERRADA')),
    CONSTRAINT CK_CTA_CONTA_ENCERRAMENTO CHECK (DATA_ENCERRAMENTO IS NULL OR DATA_ENCERRAMENTO >= DATA_ABERTURA)
);

COMMENT ON TABLE TB_CTA_CONTA IS 'Contas bancarias (corrente e poupanca) do usuario';
COMMENT ON COLUMN TB_CTA_CONTA.ID_USUARIO IS 'Titular da conta (TB_PES_USUARIO, modulo 01)';
COMMENT ON COLUMN TB_CTA_CONTA.LIMITE_CHEQUE_ESPECIAL IS 'Usado apenas em conta CORRENTE';
COMMENT ON COLUMN TB_CTA_CONTA.TAXA_RENDIMENTO_MENSAL IS 'Percentual ao mes, usado apenas em POUPANCA';
