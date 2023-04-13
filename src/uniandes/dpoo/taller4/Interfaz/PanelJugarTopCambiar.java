package uniandes.dpoo.taller4.Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * PanelJugarTopCambiar
 * Este panel es el que se encontraría a la derecha
 * en el borderlayout de la ventana princiapl.
 * Contiene los botones para: iniciar un nuevo 
 * juego, reiniciar el tablero actual, mirar el top
 * 10 de jugadores y para cambiar de jugador.
 */


public class PanelJugarTopCambiar extends JPanel implements ActionListener{

    private static final String NUEVO = "NUEVO";
	private static final String REINICIAR = "REINICIAR";
	private static final String TOP = "TOP";
	private static final String CAMBIAR = "CAMBIAR";

    private VentanaPrincipal padre;

    private JButton btnNuevo;
    private JButton btnReiniciar;
    private JButton btnTop;
    private JButton btnCambiarJugador;
    
    
    public PanelJugarTopCambiar(VentanaPrincipal padre) {

        this.padre = padre;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(400,600);

        btnNuevo = new JButton("NUEVO");
        btnNuevo.setActionCommand(NUEVO);
		btnNuevo.addActionListener(this);
        btnNuevo.setPreferredSize(new Dimension(350,50));
        add(btnNuevo);

        btnReiniciar = new JButton("REINICIAR");
        btnReiniciar.setActionCommand(REINICIAR);
		btnReiniciar.addActionListener(this);
        btnReiniciar.setPreferredSize(new Dimension(350,50));
        add(btnReiniciar);

        btnTop = new JButton("TOP-10");
        btnTop.setActionCommand(TOP);
		btnTop.addActionListener(this);
        btnTop.setPreferredSize(new Dimension(350,50));
        add(btnTop);

        btnCambiarJugador = new JButton("CAMBIAR JUGADOR");
        btnCambiarJugador.setActionCommand(CAMBIAR);
		btnCambiarJugador.addActionListener(this);
        btnCambiarJugador.setPreferredSize(new Dimension(350,50));
        add(btnCambiarJugador);


    
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		if(grito.equals(NUEVO)) {
            padre.nuevoTablero();
		}
		else if(grito.equals(REINICIAR)) {
            padre.reiniciarTablero();
		}
        else if(grito.equals(TOP)) {
            padre.verTop10();
        }
        else if(grito.equals(CAMBIAR)) {
            String nombreJugador = JOptionPane.showInputDialog("Nombre Jugador:");

            padre.cambiarJugador(nombreJugador);

        }
    }

}
