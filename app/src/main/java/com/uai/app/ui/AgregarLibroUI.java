package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class AgregarLibroUI extends UAIJFrame {
    private JPanel mainPanel;
    private JLabel Encabezado;
    private JTextField titulo;
    private JTextField autor;
    private JTextField sec;
    private JTextField piso;
    private JTextField edificio;
    private JTextField sede;
    private JButton EditarButton;
    private JTextField num;


    public AgregarLibroUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);
        EditarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tit=titulo.getText();
                String aut=autor.getText();
                String est=sec.getText();
                String edi=edificio.getText();
                String sed=sede.getText();
                int enu=Integer.parseInt(num.getText());
                int pis=Integer.parseInt(piso.getText());

                HashSet<Libro> data = DataManager.getInstance().getData();
                LibroBuilder bo = new LibroBuilder();
                Libro book = (bo.build(aut,enu,est,tit,pis,edi,sed));
                dispose();
                DataManager.getInstance().agregarLibro(book);

            }

        });
    }
}