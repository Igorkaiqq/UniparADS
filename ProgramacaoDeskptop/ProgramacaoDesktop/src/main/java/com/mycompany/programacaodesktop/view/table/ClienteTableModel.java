 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programacaodesktop.view.table;

import com.mycompany.programacaodesktop.model.Cliente;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author igork
 */
public class ClienteTableModel extends DefaultTableModel {

    //titulos colunas
    public ClienteTableModel() {
        this.addColumn("Nome");
        this.addColumn("Telefone");
        this.addColumn("Endereço");
        this.addColumn("Ativo");
    }
    
    public ClienteTableModel(List<Cliente> listCliente) {
        this();
        
        for (Cliente cliente : listCliente) {
            this.addRow(new String[] {
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEndereco(),
                cliente.getAtivo() ? "Ativo" : "Inativo"});
        }
    }
    
    public Cliente getSelectedCliente(JTable table, List<Cliente> clientes) {
        //TODO
        return null;
    }

}