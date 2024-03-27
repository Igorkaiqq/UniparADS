CREATE TABLE medico (
    Id SERIAL PRIMARY KEY,
    PessoaId INT UNIQUE,
    Especialidadeid INT,
    StatusRegistro INT NOT NULL,
    FOREIGN KEY (PessoaId) REFERENCES pessoa(id),
    FOREIGN KEY (Especialidadeid) REFERENCES especialidade(id)
);