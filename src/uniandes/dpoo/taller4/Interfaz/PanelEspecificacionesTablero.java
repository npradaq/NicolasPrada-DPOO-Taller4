package uniandes.dpoo.taller4.Interfaz;

import java.awt.event.ItemListener;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * PanelEspecificacionesTablero
 * Este panel es el que se encontraría arriba
 * en el borderlayout de la ventana princiapl.
 * Desde aqui se debe poder cambiar el tamaño del
 * tablro y la dificultad del mismo.
 */

public class PanelEspecificacionesTablero extends JPanel implements ItemListener{

    private VentanaPrincipal padre;

    private JLabel labelTamanio;
    private JLabel labelDificultad;
    private JComboBox<String> lDesplegableTamanios;
    private JComboBox<String> lDesplegableDificultad;


    public PanelEspecificacionesTablero(VentanaPrincipal padre) {

        this.padre = padre;

        setLayout(new FlowLayout());
        setSize(1000,25);

        labelTamanio = new JLabel("Tamanio:");
        labelTamanio.setSize(200,20);

        labelDificultad = new JLabel("Dificultad:");
        labelDificultad.setSize(200,20);

        lDesplegableTamanios = new JComboBox<String>();
        lDesplegableTamanios.setSize(200,20);

        lDesplegableDificultad = new JComboBox<String>();
        lDesplegableDificultad.setSize(200,20);

        add(labelTamanio);
        add(lDesplegableTamanios);
        lDesplegableTamanios.addItem("5x5");
        lDesplegableTamanios.addItem("6x6");
        lDesplegableTamanios.addItem("7x7");
        lDesplegableTamanios.addItem("8x8");
        lDesplegableTamanios.addItem("9x9");
        lDesplegableTamanios.addItem("10x10");
        lDesplegableTamanios.addItemListener(this);

        add(labelDificultad);
        add(lDesplegableDificultad);
        lDesplegableDificultad.addItem("Facil");
        lDesplegableDificultad.addItem("Medio");
        lDesplegableDificultad.addItem("Dificil");
        lDesplegableDificultad.addItemListener(this);

    }
    
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==lDesplegableTamanios) {
            String seleccionado=(String)lDesplegableTamanios.getSelectedItem();

            switch (seleccionado) {
                case "5x5":
                    padre.setTamanioTablero(5);
                    break;

                case "6x6":
                    padre.setTamanioTablero(6);
                    break;

                case "7x7":
                    padre.setTamanioTablero(7);
                    break;

                case "8x8":
                    padre.setTamanioTablero(8);
                    break;

                case "9x9":
                    padre.setTamanioTablero(9);
                    break;

                case "10x10":
                    padre.setTamanioTablero(10);
                    break;
            
                default:
                    padre.setTamanioTablero(5);
                    break;
            }

        }
        else if (e.getSource()==lDesplegableDificultad){
            String seleccionado=(String)lDesplegableDificultad.getSelectedItem();

            switch (seleccionado) {
                case "Facil":
                    padre.setDificultad(5);
                    break;

                case "Medio":
                    padre.setDificultad(10);;
                    break;

                case "Dificil":
                    padre.setDificultad(15);
                    break;
            
                default:
                    padre.setDificultad(5);
                    break;
            }

        }
    }    

}
