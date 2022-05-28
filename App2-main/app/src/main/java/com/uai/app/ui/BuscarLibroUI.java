package com.uai.app.ui;

import com.uai.app.exceptions.DataNotLoadedException;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class BuscarLibroUI extends UAIJFrame {
    private JPanel BuscarLibro;
    private JLabel Encabezado;
    private JButton buscarLibroButton;
    private JTextField Listenertitulo;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JTextPane textPane3;
    private JTextPane textPane4;
    private JTextPane textPane5;
    private JTextArea textArea1;


    public BuscarLibroUI(String title) {
        super(title);
        this.setMainPanel(BuscarLibro);
        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        try {
            String data =    DataManager.getInstance().getDataAsString();

        } catch (DataNotLoadedException e) {
            textArea1.setText(e.getMessage());
        }


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
