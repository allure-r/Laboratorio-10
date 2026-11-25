package actividad.multimedia;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class AppAudio {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Reproducción de Audio"); // Crea la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al salir
        frame.setSize(320, 180); // Establece el tamaño de la ventana
        JButton playButton = new JButton("Reproducir Audio"); // Crea el botón de reproducción
        playButton.addActionListener(e -> playAudio("src/actividad/multimedia/assets/sample-3s.wav")); // Reproduce el WAV al hacer clic
        frame.add(playButton); // Agrega el botón a la ventana
        frame.setVisible(true); // Muestra la ventana
    }

    public static void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath); // Crea el archivo de audio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile); // Lee el archivo WAV
            Clip clip = AudioSystem.getClip(); // Obtiene un reproductor de audio
            clip.open(audioStream); // Carga el audio en el reproductor
            clip.start(); // Inicia la reproducción
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace(); // Muestra el error si no se puede reproducir el audio
        }
    }
}
