CREATE TABLE paciente (
    Id SERIAL PRIMARY KEY,
    PessoaId INT UNIQUE,
    StatusRegistro INT NOT NULL,
    FOREIGN KEY (PessoaId) REFERENCES pessoa(Id)
);
