/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maniparquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author igork
 */
public class Main {
    public static void main(String[] args) {
        
        File pasta = new File("C:\\Documentos\\minha_pasta");
        pasta.mkdirs();
        
        File arquivo = new File(pasta, "arquivo.txt");
        
        try {
            FileWriter writer = new FileWriter(arquivo);
            for (int i = 1; i <= 10; i++) {
                writer.write("9 x " + i + " = " + (9 * i) + "\n");
            }
            writer.close();
            
            FileReader ler = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(ler);
            
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }
            
            ler.close();
            
            arquivo.delete();
            
            pasta.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

