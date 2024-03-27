CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    Logradouro VARCHAR(255) NOT NULL,
    Numero INT NOT NULL,
    Complemento VARCHAR(100),
    Bairro VARCHAR(100) NOT NULL,
    Cep VARCHAR(8) NOT NULL,
    CidadeId INT,
    FOREIGN KEY (CidadeId) REFERENCES cidade(Id)
);
