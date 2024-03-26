/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.infraestructure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;

/**
 *
 * @author igork
 */
public class Conexao {
    
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private DataSource dataSource;

    private static final String RESOURCE_NAME = "postgresResource";
    
    private DataSource getDatasource() throws NamingException {
        
        Context c = new InitialContext();
        return (DataSource) c.lookup(RESOURCE_NAME);
        
    }
    
    public Connection conectar() {
        
        try {
            
            con = getDatasource().getConnection();
            return con;
            
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());
        
        } 
        
        return null;
        
    }
    
    public boolean executarSQL (String sql){
        
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean executarUpdateDelete(String sql) {
        try {
            stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int insertSql(String sql){
        int status = 0;
        try {
            stm = con.createStatement();
            stm.executeUpdate(sql);
            rs = stm.executeQuery("SELECT last_insert_id();");
            while (rs.next()) {                
                status = rs.getInt(1);
            }
            return status;
        } catch (Exception e) {
            e.printStackTrace();
            return status;
        }
    }
    
    public boolean fecharConexao(){
        try {
                if (rs != null && stm != null) {
                stm.close();
                rs.close();
                con.close();
           }                
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());    
            return false;
        }
    }
    
}
