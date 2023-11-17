CREATE TABLE IF NOT EXISTS public.tb_chamados (
    id_chamados serial PRIMARY KEY,
    prestador INT,
    user_cad INT,
    datatime TIMESTAMP,
    data_finalizado TIMESTAMP,
    descricao VARCHAR(250),
    protocolo VARCHAR(20),
    status VARCHAR(10),
    title VARCHAR(50),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_prestador_id
          FOREIGN KEY(prestador)
          REFERENCES tb_prestadores(id_prestador)
);