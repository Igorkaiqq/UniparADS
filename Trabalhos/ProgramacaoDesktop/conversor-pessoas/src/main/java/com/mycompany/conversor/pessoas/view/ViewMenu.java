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

}
