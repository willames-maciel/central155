CREATE TABLE IF NOT EXISTS public.tb_prestadores (
    id_prestador serial PRIMARY KEY,
    prestador VARCHAR (50) UNIQUE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);