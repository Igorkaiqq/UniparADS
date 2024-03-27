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
    
    public boolean executarSQL (String sql){
        
        try {
            
            this.setStm(this.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            this.setRs(this.getStm().executeQuery(sql));
            fecharConexao();
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean executarUpdateDelete(String sql) {
        try {

            this.setStm(this.getCon().createStatement());
            this.getStm().executeUpdate(sql);
            fecharConexao();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public int insertSql(String sql){
        int status = 0;
        try {
            this.setStm(this.getCon().createStatement());
            this.getStm().executeUpdate(sql);
            this.setRs(this.getStm().getGeneratedKeys());
            while (this.getRs().next()) {
                status = this.getRs().getInt(1);
            }
            fecharConexao();
            return status;
        } catch (Exception e) {
            e.printStackTrace();
            return status;
        }
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
