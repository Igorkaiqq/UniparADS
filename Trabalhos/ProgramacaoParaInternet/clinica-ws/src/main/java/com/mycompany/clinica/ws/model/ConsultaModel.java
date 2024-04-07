package com.mycompany.clinica.ws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaModel {

    private int id;
    private PacienteModel paciente;
    private MedicoModel medico;
    private LocalDateTime dataHora;
    private String motivoCancelamento;
    private int statusRegistro;

}
