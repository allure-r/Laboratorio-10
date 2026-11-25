package laboratorio10.ejercicio4;

// Importamos las clases necesarias para trabajar con archivos de audio
import javax.sound.sampled.*;
import java.net.URL;

public class ReproductorMusica {
    private Clip clip; // Guarda la pista de musica actual
    private long posicionMicrosegundos = 0; // Guarda la posición actual de la reproducción
    private boolean pausado = false; // Indica si la música esta pausada

    // Método para reproducir un archivo de música
    public void reproducir(String nombreArchivo) {
        try {
            cerrarClipActual(); // Cierra cualquier reproducción anterior
            // Obtiene la ubicación del archivo de música
            URL url = getClass().getResource(nombreArchivo);

            // Verificamos si el archivo existe
            if (url == null) {
                System.err.println("No se encontró el archivo de música: " + nombreArchivo);
                return;
            }

            // Obtiene un clip para reproducir la música
            clip = AudioSystem.getClip();

            // Carga el archivo de audio
            try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(url)) {
                clip.open(audioStream);
            }

            // Inicializa la reproduccion desde el inicio
            posicionMicrosegundos = 0;
            pausado = false;
            clip.setMicrosecondPosition(0);
            clip.start();

        } catch (Exception e) {
            // Muestra un mensaje si ocurre un error al reproducir la música
            System.err.println("Error al reproducir la pista: " + e.getMessage());
            e.printStackTrace();
        }

    }

    // Método para pausar la reproducción de música
    public void pausar() {
        if (clip != null && clip.isRunning()) {
            posicionMicrosegundos = clip.getMicrosecondPosition(); // Guarda la posición actual
            clip.stop(); // Detiene temporalmente la reproducción
            pausado = true; // Indica que la música esta pausada
        }
    }

    // Método para continuar la reproducción desde donde se pauso
    public void reanudar() {
        if (clip != null && pausado && !clip.isRunning()) {
            clip.setMicrosecondPosition(posicionMicrosegundos); // Recupera la posición guardada
            clip.start(); // Continua la reproducción
            pausado = false; // Actualiza el estado de reproducción
        }
    }

    // Método para detener y cerrar el clip actual
    public void cerrarClipActual() {
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop(); // Detiene la reproducción si esta activa
            }
            clip.close(); // Libera los recursos del clip
            clip = null; // Limpia la referencia al clip actual
        }
        posicionMicrosegundos = 0; // Reinicia la posición de reproducción
        pausado = false; // Restablece el estado de pausa
    }
}