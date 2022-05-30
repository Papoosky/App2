package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class EliminarLibroUI extends UAIJFrame {
    private JPanel BuscarLibro;
    private JButton buscarButton;
    private JTextField Cuadrotextobuscarlibro;
    private JTextPane textPane1;


    public EliminarLibroUI(String title) {
        super(title);
        this.setMainPanel(BuscarLibro);


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tit = Cuadrotextobuscarlibro.getText();

                HashSet<Libro> data = DataManager.getInstance().getData();
                int existencia=0;
                for (Libro p: data){
                    if (p.getTitulo().equals(tit)){
                        existencia++;
                    }
                }
                if (existencia==0){
                    JFrame error= new JFrame();
                    JOptionPane.showMessageDialog(error,"¡no se encontro el libro!");
                }
                //existencia se utiliza para saber si se encuentra el libro, 0 si no existe, 1 si existe
                if (existencia==1){
                    for (Libro p:data){
                        if (p.getTitulo().equals(tit)){
                            data.remove(p);
                            JFrame success= new JFrame();
                            JOptionPane.showMessageDialog(success,"¡Libro eliminado!");
                            break;
                        }
                    }
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
