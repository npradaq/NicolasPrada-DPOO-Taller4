package uniandes.dpoo.taller4.Interfaz;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * PanelPuntuacionJugador
 * Este panel es el que se encontraría abajo
 * en el borderlayout de la ventana princiapl.
 * Debe mostrar el numero de jugadas y el nombre
 * del jugador que está jugando actualmente
 */

public class PanelPuntuacionJugador extends JPanel{

    private JLabel labelJugadas;
    private JLabel labelJugador;
    private JTextField textJugadas;
    private JTextField textNombre;

    
    public PanelPuntuacionJugador(VentanaPrincipal padre) {

        setLayout(new FlowLayout());
        setSize(1000,25);

        labelJugadas = new JLabel("Jugadas:");
        labelJugadas.setSize(200,20);


        labelJugador = new JLabel("Jugador:");
        labelJugador.setSize(200,20);

        textJugadas = new JTextField(10);
        textJugadas.setText("0");
        textJugadas.setEditable(false);
        textJugadas.setSize(200,20);
        labelJugadas.setLabelFor(textJugadas);

        textNombre = new JTextField(20);
        textNombre.setText("ABC");
        textNombre.setEditable(false);
        textNombre.setSize(200,20);
        labelJugador.setLabelFor(textNombre);

        add(labelJugadas);
        add(textJugadas);
        add(labelJugador);
        add(textNombre);

    }

    public void actualizarJugadas(int numJugadas) {

        textJugadas.setText(String.valueOf(numJugadas));

    }

    public void actualizarJugador(String nombreJugador) {
        
        textNombre.setText(nombreJugador);

    }

    public String getNombreJugador() {
        return textNombre.getText();
    } 
    

}
