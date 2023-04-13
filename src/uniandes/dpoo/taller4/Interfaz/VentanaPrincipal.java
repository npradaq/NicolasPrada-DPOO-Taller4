package uniandes.dpoo.taller4.Interfaz;

import java.util.Collection;
import java.util.Iterator;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.awt.event.WindowEvent;    
import java.awt.event.WindowListener;   
import java.awt.GridLayout;


import javax.swing.JFrame;
import javax.swing.JLabel;

import static javax.swing.JOptionPane.showMessageDialog;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaPrincipal extends JFrame implements WindowListener{
    
    private int tamanioTablero;
    private int dificultad;

    private Tablero tablero;
    private Top10 top10;

    private PanelTablero panelTablero;
    private PanelEspecificacionesTablero panelEspecificaciones;
    private PanelJugarTopCambiar panelJugarTopCambiar;
    private PanelPuntuacionJugador panelPuntuacionJugador;
    
    
    public VentanaPrincipal() {
        addWindowListener(this);

        this.tamanioTablero = 5;
        this.dificultad = 5;
        this.top10 = new Top10();

        top10.cargarRecords(new File("./data/top10.csv"));

        setLayout(new BorderLayout());
        
        panelTablero = new PanelTablero(this);
        nuevoTablero();

        panelEspecificaciones = new PanelEspecificacionesTablero(this);
        panelJugarTopCambiar = new PanelJugarTopCambiar(this);
        panelPuntuacionJugador = new PanelPuntuacionJugador(this);


        add(panelTablero, BorderLayout.CENTER);
        add(panelJugarTopCambiar, BorderLayout.EAST);
        add(panelPuntuacionJugador, BorderLayout.SOUTH);
        add(panelEspecificaciones, BorderLayout.NORTH);

        setTitle("LightsOut");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,650);
        

        setResizable(false);
        setVisible(true);
    }

    public void cambiarJugador(String nombreJugador) {
        panelPuntuacionJugador.actualizarJugador(nombreJugador);
    }

    public void nuevoTablero() {
        this.tablero = new Tablero(tamanioTablero);

        tablero.desordenar(dificultad);

        panelTablero.crearNuevoTablero(tamanioTablero);
        panelTablero.revalidate();
        panelTablero.repaint();
        
    }

    public void reiniciarTablero() {
        tablero.reiniciar();
        panelTablero.repintarTablero(tablero.darTablero());
    }

    public void verTop10(){
        JFrame ventanaTop = new JFrame();
        ventanaTop.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ventanaTop.setSize(300,600);
        ventanaTop.setLayout(new GridLayout(11,1));

        JLabel inicio = new JLabel("#  NOMBRE  PUNTOS");
        inicio.setSize(250,100);
        ventanaTop.add(inicio);

        Collection<RegistroTop10> registro =  top10.darRegistros();

        Iterator<RegistroTop10> iterator = registro.iterator();

        int i = 0;
        while(iterator.hasNext() && i < 10){

            RegistroTop10 registroActual = iterator.next();
            JLabel dato = new JLabel(String.valueOf(i+1)+ " " + registroActual.toString());
            dato.setSize(300,50);

            ventanaTop.add(dato);

            i++;
        }

        ventanaTop.setVisible(true);

    }

    public void setTamanioTablero(int tamanioTablero) {
        this.tamanioTablero = tamanioTablero;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void tableroPresionado(int x, int y) {
        tablero.jugar(x, y);

        panelPuntuacionJugador.actualizarJugadas(tablero.darJugadas());
        panelTablero.repintarTablero(tablero.darTablero());

        if(tablero.tableroIluminado()){
            panelTablero.setGanar(true);
            int puntaje = tablero.calcularPuntaje();
            String nombreJugador = panelPuntuacionJugador.getNombreJugador();
            showMessageDialog(null, "FELICIDADES "+nombreJugador+"!\n Su puntuacion es: " + puntaje);
            
            top10.agregarRegistro(nombreJugador, puntaje);
            
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            top10.salvarRecords(new File("./data/top10.csv"));
        } catch (FileNotFoundException | UnsupportedEncodingException i) {
            i.printStackTrace();
        }
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    public static void main(String[] args) {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
    }
    
}
