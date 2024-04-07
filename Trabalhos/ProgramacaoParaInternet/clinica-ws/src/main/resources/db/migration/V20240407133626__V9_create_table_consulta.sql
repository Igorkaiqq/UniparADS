CREATE TABLE consulta (
                          Id SERIAL PRIMARY KEY,
                          PacienteId INTEGER NOT NULL,
                          MedicoId INTEGER NOT NULL,
                          DataHora TIMESTAMP NOT NULL,
                          MotivoCancelamento VARCHAR(255),
                          StatusRegistro INTEGER DEFAULT 1, -- 1 para consulta agendada, 0 para consulta cancelada
                          FOREIGN KEY (PacienteId) REFERENCES paciente(Id),
                          FOREIGN KEY (MedicoId) REFERENCES medico(Id)
);
