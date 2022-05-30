package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.builders.LibroBuilder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;




public class EditarLibroUI {
    private JTextField Titulo;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton editarButton;
    private JPanel Panel;
    private JPanel Panel2;

    public EditarLibroUI(JFrame title){
        super(title);
        this.setMainPanel(mainPanel);



        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tit=textField1.getText();
                String aut=textField7.getText();
                String est=textField5.getText();
                String edi=textField3.getText();
                String sed=textField2.getText();
                int enu=Integer.parseInt(textField6.getText());
                int pis=Integer.parseInt(textField4.getText());


                String searchTerm= tit;
                boolean found = false;
                Scanner x;
                x= new Scanner(new File(data.csv));
                x.useDelimiter("[,\'n]");

                while(x.hasNext() && !found){
                    if(Libro.titulo.equals(searchTerm)){
                        found = true;
                        HashSet<Libro> data = DataManager.getInstance().getData();
                        LibroBuilder lib = new LibroBuilder();
                        Libro book = (lib.build(aut,enu,est,tit,pis,edi,sed));
                        DataManager.getInstance().EditarLibro(book);

                    }

                }








            }
        });
        


    }







    }



