<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.conversor.pessoas.view;

import com.mycompany.conversor.pessoas.controller.PessoaController;
import com.mycompany.conversor.pessoas.model.PessoaModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author igork
 */
public class ViewMenu extends javax.swing.JFrame {

    /**
     * Creates new form ViewExportar
     */
    private Map<String, String> colunaAtributoMap;
    public ViewMenu() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);
        jlPessoas.setText("Pessoas");
        jlPessoas.setAlignmentX(CENTER_ALIGNMENT);
        mapearColunas();
        atualizarTabela();
    }

    public void mapearColunas(){
        colunaAtributoMap = new HashMap<>();
        colunaAtributoMap.put("nome", "nome");
        colunaAtributoMap.put("idade", "idade");
        colunaAtributoMap.put("cpf", "cpf");
        colunaAtributoMap.put("rg", "rg");
        colunaAtributoMap.put("data_nasc", "data_nasc");
        colunaAtributoMap.put("sexo", "sexo");
        colunaAtributoMap.put("signo", "signo");
        colunaAtributoMap.put("mae", "mae");
        colunaAtributoMap.put("pai", "pai");
        colunaAtributoMap.put("email", "email");
        colunaAtributoMap.put("senha", "senha");
        colunaAtributoMap.put("cep", "cep");
        colunaAtributoMap.put("endereco", "endereco");
        colunaAtributoMap.put("numero", "numero");
        colunaAtributoMap.put("bairro", "bairro");
        colunaAtributoMap.put("cidade", "cidade");
        colunaAtributoMap.put("estado", "estado");
        colunaAtributoMap.put("telefone_fixo", "telefone_fixo");
        colunaAtributoMap.put("celular", "celular");
        colunaAtributoMap.put("altura", "altura");
        colunaAtributoMap.put("peso", "peso");
        colunaAtributoMap.put("tipo_sanguineo", "tipo_sanguineo");
        colunaAtributoMap.put("cor", "cor");
    }

    public void importarArquivo() throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos .csv", "csv");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(filtro);
        fileChooser.setDialogTitle("Importar arquivo");
        int resposta = fileChooser.showOpenDialog(null);
        if (resposta == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Arquivo selecionado: " + arquivo.getName());
            lerArquivo(arquivo);
            atualizarTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado");
        }
    }

    public void lerArquivo(File arquivo) {
        String linha;
        String split = ";";
        List<PessoaModel> listaPessoas = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "UTF-8"))) {
            if ((linha = buffer.readLine()) != null) {
                String[] colunas = linha.split(split);
                while ((linha = buffer.readLine()) != null) {
                    String[] valores = linha.split(split);
                    PessoaModel pessoa = new PessoaModel();
                    for (int i = 0; i < colunas.length; i++) {
                        String atributo = colunaAtributoMap.get(colunas[i]);
                        if (atributo != null) {
                            setAtributo(pessoa, atributo, valores[i]);
                        }
                    }
                    listaPessoas.add(pessoa);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        salvarPessoa((ArrayList<PessoaModel>) listaPessoas);
    }

    private void setAtributo(PessoaModel pessoa, String atributo, String valor) {
        try {
            Field campo = pessoa.getClass().getDeclaredField(atributo);
            campo.setAccessible(true);
            Class<?> fieldType = campo.getType();
            if (fieldType == String.class) {
                campo.set(pessoa, valor);
            } else if (fieldType == int.class) {
                campo.setInt(pessoa, Integer.parseInt(valor));
            } else if (fieldType == double.class) {
                campo.setDouble(pessoa, Double.parseDouble(valor));
            }
        } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Atributo: " + atributo +". Valor: "+valor);
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void salvarPessoa(ArrayList<PessoaModel> listaPessoas){
        PessoaController pessoaController = new PessoaController();
        for (PessoaModel pessoa : listaPessoas){
            pessoaController.salvarPessoaController(pessoa);
        }
    }

    public ArrayList<PessoaModel> carregarPessoas(){
        PessoaController pessoaController = new PessoaController();
        return pessoaController.getAllPessoaController();
    }

    public void atualizarTabela(){
        List<PessoaModel> listaPessoas = carregarPessoas();
        DefaultTableModel model = (DefaultTableModel) jtPessoas.getModel();
        model.setRowCount(0);
        for (PessoaModel pessoa : listaPessoas) {
            model.addRow(new Object[]{
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getRg(),
                pessoa.getData_nasc(),
                pessoa.getSexo(),
                pessoa.getSigno(),
                pessoa.getMae(),
                pessoa.getPai(),
                pessoa.getEmail(),
                pessoa.getSenha(),
                pessoa.getCep(),
                pessoa.getEndereco(),
                pessoa.getNumero(),
                pessoa.getBairro(),
                pessoa.getEstado(),
                pessoa.getTelefone_fixo(),
                pessoa.getCelular(),
                pessoa.getAltura(),
                pessoa.getPeso(),
                pessoa.getTipo_sanguineo(),
                pessoa.getCor()
            });
        }
    }

    public void exportarArquivo(){
        String texto = JOptionPane.showInputDialog("Digite o nome do arquivo");
        if (texto != null) {
            String nomeArquivo = texto + ".csv";
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvar arquivo");
            fileChooser.setSelectedFile(new File(nomeArquivo));
            int resposta = fileChooser.showSaveDialog(null);
            if (resposta == JFileChooser.APPROVE_OPTION) {
                File arquivo = fileChooser.getSelectedFile();
                salvarArquivo(arquivo);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado");
            }
        }
    }

    public void salvarArquivo(File arquivo){
        String split = ";";
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(arquivo))) {
            buffer.write("id;nome;cpf;rg;data_nasc;sexo;signo;mae;pai;email;senha;cep;endereco;numero;bairro;estado;telefone_fixo;celular;altura;peso;tipo_sanguineo;cor");
            buffer.newLine();
            for (PessoaModel pessoa : carregarPessoas()) {
                buffer.write(pessoa.getId() + split);
                buffer.write(pessoa.getNome() + split);
                buffer.write(pessoa.getCpf() + split);
                buffer.write(pessoa.getRg() + split);
                buffer.write(pessoa.getData_nasc() + split);
                buffer.write(pessoa.getSexo() + split);
                buffer.write(pessoa.getSigno() + split);
                buffer.write(pessoa.getMae() + split);
                buffer.write(pessoa.getPai() + split);
                buffer.write(pessoa.getEmail() + split);
                buffer.write(pessoa.getSenha() + split);
                buffer.write(pessoa.getCep() + split);
                buffer.write(pessoa.getEndereco() + split);
                buffer.write(pessoa.getNumero() + split);
                buffer.write(pessoa.getBairro() + split);
                buffer.write(pessoa.getEstado() + split);
                buffer.write(pessoa.getTelefone_fixo() + split);
                buffer.write(pessoa.getCelular() + split);
                buffer.write(pessoa.getAltura() + split);
                buffer.write(pessoa.getPeso() + split);
                buffer.write(pessoa.getTipo_sanguineo() + split);
                buffer.write(pessoa.getCor());
                buffer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPessoas = new javax.swing.JTable();
        jbImport = new javax.swing.JButton();
        jbExport = new javax.swing.JButton();
        jlPessoas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 400));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(400, 400));

        jPanel1.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));

        jtPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "CPF", "RG", "dt_Nasc", "sexo", "Signo", "Mae", "Pai", "Email", "Senha", "CEP", "Endereco", "Numero", "Bairro", "Estado", "Telefone", "Celular", "Altura", "Peso", "Sanguineo", "Cor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtPessoas);

        jbImport.setText("Importar");
        jbImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jbImportActionPerformed(evt);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jbExport.setText("Exportar tudo");
        jbExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExportActionPerformed(evt);
            }
        });

        jlPessoas.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jlPessoas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPessoas.setText("Pessoas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jbImport, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jbExport, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jlPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlPessoas)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbImport)
                    .addComponent(jbExport))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbImportActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {//GEN-FIRST:event_jbImportActionPerformed
        importarArquivo();
    }//GEN-LAST:event_jbImportActionPerformed

    private void jbExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExportActionPerformed
        // TODO add your handling code here:
        exportarArquivo();
    }//GEN-LAST:event_jbExportActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExport;
    private javax.swing.JButton jbImport;
    private javax.swing.JLabel jlPessoas;
    private javax.swing.JTable jtPessoas;
    // End of variables declaration//GEN-END:variables
=======
package com.mycompany.conversor.pessoas.view;

import javax.swing.*;

public class ViewMenu extends JFrame {
    private JButton btExportar;
    private JButton btImportar;
    private JPanel PanelMenu;

    public ViewMenu(){
    }

    public static void main(String[] args) {
        ViewMenu viewMenu = new ViewMenu();
        viewMenu.setContentPane(viewMenu.PanelMenu);
        viewMenu.setSize(300, 300);
        viewMenu.setLocale(null);
        viewMenu.setResizable(false);
        viewMenu.setVisible(true);
        viewMenu.setLocationRelativeTo(null);
        viewMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

>>>>>>> d772ed9c5f7e64b03fa61d21e2469180235e3b9c
}
