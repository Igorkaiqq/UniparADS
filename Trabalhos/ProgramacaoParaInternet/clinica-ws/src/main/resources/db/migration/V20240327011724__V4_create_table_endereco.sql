CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    Logradouro VARCHAR(150) NOT NULL,
    Numero INT NOT NULL,
    Complemento VARCHAR(100),
    Bairro VARCHAR(100) NOT NULL,
    Cep VARCHAR(12) NOT NULL,
    CidadeId INT,
    FOREIGN KEY (CidadeId) REFERENCES cidade(Id)
);
