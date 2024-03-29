/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.infraestructure;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
@Getter
@Setter
public class Conexao {
    
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private DataSource dataSource;
    private PreparedStatement pstm = null;
    
    private static final String RESOURCE_NAME = "postgresResource";
    
    private DataSource getDatasource() throws NamingException {
        
        Context c = new InitialContext();
        return (DataSource) c.lookup(RESOURCE_NAME);
        
    }
    
    public Connection conectar() {
        
        try {
            
            this.setCon(getDatasource().getConnection());
            
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());
        
        } 
        
        return this.getCon();
        
    }
    
    public boolean fecharConexao() {
        try {
            if ((this.getRs() != null) && (this.getStm() != null)) {
                this.getRs().close();
                this.getStm().close();
            }
            this.getCon().close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    
}
