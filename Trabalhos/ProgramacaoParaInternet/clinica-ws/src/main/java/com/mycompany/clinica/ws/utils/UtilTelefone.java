package com.mycompany.clinica.ws.utils;

public class UtilTelefone {

    public static String formatarTelefone(String telefone) {

        telefone = telefone.replaceAll("[^\\d]", "");

        return "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 7) + "-" + telefone.substring(7, 11);
    }

}
