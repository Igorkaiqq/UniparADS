package com.mycompany.conversor.pessoas.infraestrutura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class EntityManagerUtil {

    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static Connection connection = null;
    private static String USUARIO = "postgres";
    private static String SENHA = "Nesher#2019";

    public static EntityManagerFactory getEntityManagerFactory(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("DesktopPU");
            System.out.println("Conexão aberta");
        }
        return emf;
    }

    public static EntityManager getManager(){
        if(em == null || !em.isOpen()){
            em = (EntityManager) getEntityManagerFactory().createEntityManager();
            System.out.println("COnexão aberta");
        }
        return em;
    }

    public static void closeEntityManagerFactory(){
        if(emf != null && emf.isOpen()){
            emf.close();
            System.out.println("Conexão Fechada!");
        }
    }

    public static Connection getConexao() {
        try{
            if(connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pessoa", USUARIO, SENHA);
                return connection;
            }

            return connection;
        } catch(Exception ex) {
            connection = null;
            System.out.println("Erro ao abrir conexão");
        }

        return null;
    }

}
