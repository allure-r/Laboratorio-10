package laboratorio10.ejercicio3;

// Importamos las clases necesarias para trabajar con archivos de sonido
import javax.sound.sampled.*;
import java.net.URL;

public class ReproductorSonido {

    private Clip clipActual; // Guarda el sonido que se está reproduciendo

    // Método para reproducir un archivo de audio
    public void reproducir(String nombreArchivo) {

        try {
            // Obtiene la ubicación del archivo de audio
            URL url = getClass().getResource(nombreArchivo);

            // Verifica si el archivo existe
            if (url == null) {
                System.out.println("No se encontro el archivo de audio: " + nombreArchivo);
                return;
            }

            // Detiene y cierra el sonido anterior si existe
            if (clipActual != null) {
                if (clipActual.isRunning()) {
                    clipActual.stop();
                }
                clipActual.close();
            }

            // Carga el archivo de audio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);

            // Obtiene un clip para reproducir el sonido
            Clip clip = AudioSystem.getClip();

            // Detecta cuando termina la reproducción del sonido
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

            // Abre el archivo y comienza su reproducción
            clip.open(audioStream);
            clip.start();

            // Guarda el clip actual
            clipActual = clip;

        } catch (Exception e) {
            // Muestra un mensaje si ocurre un error al reproducir el sonido
            System.err.println("Error al reproducir " + nombreArchivo + ": " + e.getMessage());
            e.printStackTrace();
        }

    }

}