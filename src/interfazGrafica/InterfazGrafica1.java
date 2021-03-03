package interfazGrafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InterfazGrafica1 extends JFrame {
    
    private int contador = 0;
  
    public InterfazGrafica1() {
        setSize(700,500);
        setTitle("Contador de pulsaciones de botón");
        ubicarComponentes();
        setVisible(true);
    }

    private void ubicarComponentes() {
     
        setLayout(null);
        
                   // CONFIGURACIÓN JLabel jLabelVisualizaContador
        JLabel jLabelVisualizaContador = new JLabel("Numero de pulsaciones: "+contador);
        jLabelVisualizaContador.setBounds(100,50,300,20);
        add(jLabelVisualizaContador);
        
                   // CONFIGURACIÓN JButton jButtonContar
        JButton jButtonContar = new JButton("Contar");
        jButtonContar.setBounds(100,300,100,40);   

        jButtonContar.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                contador ++;
                jLabelVisualizaContador.setText("Numero de pulsaciones: "+contador);         
            }       
        }); 
        add(jButtonContar);
                   // CONFIGURACIÓN JButton jButtonSalir
        JButton jButtonSalir = new JButton("Salir");
        jButtonSalir.setBounds(100,400,100,40);
        ActionListener listenerJButtonSalir = new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                 System.exit(0);     
            }       
        };        
        jButtonSalir.addActionListener(listenerJButtonSalir);     // REGISTRO DE ESCUCHA DE EVENTO DE BOTON
        add(jButtonSalir);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
              @Override
              public void run() {
                 new InterfazGrafica1();
              }
           });
    }  
}