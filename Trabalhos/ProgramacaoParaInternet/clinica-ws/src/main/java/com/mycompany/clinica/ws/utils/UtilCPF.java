package com.mycompany.clinica.ws.utils;

public class UtilCPF {

    public static String formatarCPF(String cpf) {

        cpf = cpf.replaceAll("[^\\d]", "");

        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

}
