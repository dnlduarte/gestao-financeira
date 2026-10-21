-- =====================================================================
-- 00-limpeza.sql  (dono: professor - grupos NAO alteram)
-- Apaga SOMENTE as tabelas deste projeto (prefixos TB_PES_ ... TB_REL_)
-- do seu schema. Tabelas de outras disciplinas nao sao tocadas.
-- Rode antes de recriar o banco com executar-todos.sql.
-- =====================================================================
BEGIN
    FOR t IN (
        SELECT table_name
          FROM user_tables
         WHERE REGEXP_LIKE(table_name, '^TB_(PES|CTA|TRN|INV|DIV|PLN|EDU|NTF|REL)_')
    ) LOOP
        EXECUTE IMMEDIATE 'DROP TABLE "' || t.table_name || '" CASCADE CONSTRAINTS PURGE';
    END LOOP;
END;
/
