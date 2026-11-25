package actividad.multimedia;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.swing.*;
import java.io.File;

public class VideoExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Reproducción de Video"); // Crea la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al salir
        frame.setSize(800, 600); // Establece el tamaño de la ventana
        JFXPanel jfxPanel = new JFXPanel(); // Integra JavaFX en Swing
        frame.add(jfxPanel); // Agrega el componente JavaFX a la ventana
        frame.setVisible(true); // Muestra la ventana

        Platform.runLater(() -> { // Ejecuta el código en el hilo de JavaFX
            String videoPath = new File("demo.mp4").toURI().toString(); // Obtiene la ruta del video MP4
            Media media = new Media(videoPath); // Crea el recurso multimedia
            MediaPlayer mediaPlayer = new MediaPlayer(media); // Crea el reproductor de video
            MediaView mediaView = new MediaView(mediaPlayer); // Crea la vista del video
            jfxPanel.setScene(new Scene(new javafx.scene.Group(mediaView))); // Coloca el video en el panel
            mediaPlayer.play(); // Inicia la reproducción
        });
    }
}
