CREATE TABLE cidade (
    Id SERIAL PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    EstadoId INT,
    FOREIGN KEY (EstadoId) REFERENCES estado(Id)
);
