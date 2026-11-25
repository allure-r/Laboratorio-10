package actividad.multimedia;

import javax.swing.*;
import java.awt.FlowLayout;

public class AppAudioSimilar {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicación similar de Audio"); // Crea la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al salir
        frame.setSize(340, 180); // Establece el tamaño de la ventana
        frame.setLayout(new FlowLayout()); // Organiza los componentes en flujo
        JLabel mensaje = new JLabel("Presione el botón para escuchar el sonido"); // Muestra una indicación
        JButton playButton = new JButton("Reproducir sonido"); // Crea el botón de reproducción
        playButton.addActionListener(e -> { // Escucha el clic del botón
            AppAudio.playAudio("src/actividad/multimedia/assets/sample-3s.wav"); // Reutiliza el método de reproducción WAV
            mensaje.setText("Se solicitó la reproducción del audio"); // Actualiza el mensaje de la interfaz
        });
        frame.add(mensaje); // Agrega la etiqueta a la ventana
        frame.add(playButton); // Agrega el botón a la ventana
        frame.setVisible(true); // Muestra la ventana
    }
}
