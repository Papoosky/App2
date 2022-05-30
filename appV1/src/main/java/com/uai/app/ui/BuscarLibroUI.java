package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.dominio.enums.Tittles;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.SearchManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;


public class BuscarLibroUI extends UAIJFrame {
    private JPanel BuscarLibro;
    private JLabel Encabezado;
    private JButton buscarLibroButton;
    private JTextField Cuadrotextobuscarlibro;
    private JTextField sedetit;
    private JButton buscarLibroButton1;
    private JPanel mainTableConatiner2;
    private JPanel mainTableConatiner3;
    private JPanel mainTableConatiner4;

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
                //String x = SearchManager.getInstance().buscarlibroportitulo(Tittles.TITULO, tit);
                String[] titles = {"titulo", "autor", "estante_numero", "estante_seccion", "piso", "edificio", "sede"};
                //obtengo los libros en una matriz
                HashSet<Libro> finbook = SearchManager.getInstance().buscarlibroportitulo(Tittles.TITULO, tit);
                String[][] dataTabla = new String[finbook.size()][7];
                int cont = 0;
                for(Libro p : finbook) {
                    dataTabla[cont] = p.getDataToCsv();
                    cont++;
                }
                TableModel tableModel = new DefaultTableModel(dataTabla, titles);
                JTable table = new JTable(tableModel);
                mainTableConatiner3.setLayout(new BorderLayout());
                mainTableConatiner3.add(new JScrollPane(table), BorderLayout.CENTER);

                mainTableConatiner3.add(table.getTableHeader(), BorderLayout.NORTH);

                mainTableConatiner3.setVisible(true);
                mainTableConatiner3.setSize(400,400);


               // textPane1.setText(x);

                //dispose();//cierra la ventana

            }

        });

        buscarLibroButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sedet = sedetit.getText();
                SearchManager.getInstance().buscarlibroportitulo(Tittles.SEDE, sedet);
                String[] titles = {"titulo", "autor", "estante_numero", "estante_seccion", "piso", "edificio", "sede"};
                //obtengo los libros en una matriz
                HashSet<Libro> finsede = SearchManager.getInstance().buscarlibroportitulo(Tittles.SEDE, sedet);
                String[][] dataTabla = new String[finsede.size()][7];
                int cont = 0;
                for(Libro p : finsede) {
                    dataTabla[cont] = p.getDataToCsv();
                    cont++;
                }
                TableModel tableModel = new DefaultTableModel(dataTabla, titles);
                JTable table = new JTable(tableModel);
                mainTableConatiner4.setLayout(new BorderLayout());
                mainTableConatiner4.add(new JScrollPane(table), BorderLayout.CENTER);

                mainTableConatiner4.add(table.getTableHeader(), BorderLayout.NORTH);

                mainTableConatiner4.setVisible(true);
                mainTableConatiner4.setSize(400,400);
                //String y = String.valueOf(SearchManager.getInstance().buscarlibroportitulo(Tittles.SEDE, sedet));

                //textPane2.setText(y);

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
