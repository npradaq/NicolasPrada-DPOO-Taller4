package uniandes.dpoo.taller4.Interfaz;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

/*
 * PanelTablero
 * Este panel es el que deberÃ­a ir en el centro 
 * en el borderlayout de la ventana principal.
 * Este panel deberÃ­a mostrar el tablero con las
 * luces prendidas y apagadas. DeberÃ­a estar 
 * organizado con un gridlayout.
 */

public class PanelTablero extends JPanel implements ActionListener{

    private boolean ganar;

    private VentanaPrincipal padre;	

    private JButton[][] botonesJuego;

    public PanelTablero(VentanaPrincipal padre) {

        this.padre = padre;
        setSize(600,600);
    
    }

    public void crearNuevoTablero(int tamanioTablero){
        removeAll();
        ganar = false;
        
        setLayout(new GridLayout(tamanioTablero, tamanioTablero));

        botonesJuego = new JButton[tamanioTablero][tamanioTablero];
        Tablero tablero = padre.getTablero();
        boolean[][] medidasTablero = tablero.darTablero();

        for(int i = 0; i<tamanioTablero; i++)						
		{
			for(int j = 0; j<tamanioTablero; j++)
			{
				JButton button = new JButton();
				botonesJuego[i][j] = button;
				button.setName(i+","+j);
                if(medidasTablero[i][j] == true){
                    button.setBackground(Color.yellow);
                }
                else{
                    button.setBackground(Color.black);
                }
				button.addActionListener(this);
				add(button);
			}
		}
    }


    @Override
	public void actionPerformed(ActionEvent e){
        if(!ganar){
            JButton button = (JButton)e.getSource();
            String location[] = button.getName().split(",");

            int x = Integer.parseInt(location[0]);
            int y = Integer.parseInt(location[1]);

            padre.tableroPresionado(x,y);
        }
    }


    public void repintarTablero(boolean[][] tablero) {
    
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if(tablero[i][j] == true){
                    botonesJuego[i][j].setBackground(Color.yellow);
                }
                else{
                    botonesJuego[i][j].setBackground(Color.black);
                }
            }
        }
    
    }


    public void setGanar(boolean ganar) {
        this.ganar = ganar;
    }

}
