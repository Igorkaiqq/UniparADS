package com.mycompany.clinica.ws.utils;

public class UtilCRM {

    public static String formatarCRM(String crm) {

        crm = crm.replaceAll("[^\\d]", "");

        while (crm.length() < 7) {
            crm = "0" + crm;
        }
        return crm.substring(0, 6) + "-" + crm.substring(6);
    }

}
