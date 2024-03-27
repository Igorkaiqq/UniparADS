-- Verifica se o banco de dados já existe
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'clinica') THEN
    CREATE DATABASE clinica;
END IF;
END $$;