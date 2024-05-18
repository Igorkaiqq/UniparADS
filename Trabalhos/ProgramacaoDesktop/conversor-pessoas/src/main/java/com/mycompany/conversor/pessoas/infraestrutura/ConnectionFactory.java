package com.mycompany.conversor.pessoas.infraestrutura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Connection conn;
    private static String url = "jdbc:postgresql://localhost:5432/manipulacao";
    private static String usuario = "postgres";
    private static String senha = "Nesher#2019";

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("Manipulacao");
            System.out.println("Conexão com o banco de dados realizada com sucesso!");
        }
        return emf;
    }

    public static EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = getEntityManagerFactory().createEntityManager();
            System.out.println("Conexão com o banco de dados realizada com sucesso!");
        }
        return em;
    }

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, usuario, senha);
                System.out.println("Conexão com o banco de dados realizada com sucesso!");
                return conn;
            }
            return conn;
        } catch (Exception e) {
            conn = null;
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
        return null;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null || emf.isOpen()) {
            emf.close();
            System.out.println("Conexão com o banco de dados fechada com sucesso!");
        }
    }
}
