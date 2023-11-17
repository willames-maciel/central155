CREATE TABLE IF NOT EXISTS public.tb_updates (
    id_updates serial PRIMARY KEY,
    descricao VARCHAR(250),
    chamado_id INT,
    created_on TIMESTAMP NOT NULL,
    CONSTRAINT fk_chamado_id
              FOREIGN KEY(chamado_id)
              REFERENCES tb_chamados(id_chamados)
);