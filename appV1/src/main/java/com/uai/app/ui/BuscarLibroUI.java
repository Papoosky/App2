package com.uai.app.ui;

import com.uai.app.dominio.enums.Tittles;
import com.uai.app.logic.SearchManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BuscarLibroUI extends UAIJFrame {
    private JPanel BuscarLibro;
    private JLabel Encabezado;
    private JButton buscarLibroButton;
    private JTextField Cuadrotextobuscarlibro;
    private JTextPane textPane1;
    private JTextPane losLibrosSimilaresATextPane;
    private JTextPane textPane3;
    private JTextPane textPane4;
    private JTextPane textPane5;

    private JPanel mainPanel;
    private JPanel mainTableConatiner;
    private JTextArea textArea1;

    public BuscarLibroUI(String title) {
        super(title);
        this.setMainPanel(BuscarLibro);
        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String tit = Cuadrotextobuscarlibro.getText();
                SearchManager.getInstance().buscarlibroportitulo(Tittles.TITULO, tit);
                String x = String.valueOf(SearchManager.getInstance().buscarlibroportitulo(Tittles.TITULO, tit));
                /* si se encuentra el libro en x se guardan los datos del libro */

                textPane1.setText(x);

                //dispose();//cierra la ventana

            }

        });

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
