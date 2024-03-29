CREATE TABLE medico (
    Id SERIAL PRIMARY KEY,
    PessoaId INT ,
    Especialidadeid INT,
    CRM varchar(30),
    StatusRegistro INT NOT NULL,
    FOREIGN KEY (PessoaId) REFERENCES pessoa(id),
    FOREIGN KEY (Especialidadeid) REFERENCES especialidade(id)
);