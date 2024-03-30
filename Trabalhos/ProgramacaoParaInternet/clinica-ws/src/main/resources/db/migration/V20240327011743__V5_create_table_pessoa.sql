CREATE TABLE pessoa (
    Id SERIAL PRIMARY KEY,
    Nome VARCHAR(255) NOT NULL,
    Email VARCHAR(255),
    Telefone VARCHAR(15),
    Cpf VARCHAR(14) UNIQUE,
    Sexo VARCHAR(20),
    EnderecoId INT,
    FOREIGN KEY (EnderecoId) REFERENCES endereco(Id)
);
