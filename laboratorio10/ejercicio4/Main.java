package laboratorio10.ejercicio4;

// Importamos la clase necesaria para ejecutar la interfaz gráfica
import javax.swing.SwingUtilities;

public class Main {
    // Método principal del programa
    public static void main(String[] args) {
        // Ejecuta la creación de la ventana en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            VentanaMusica ventana = new VentanaMusica(); // Crea una instancia de la ventana
            ventana.setVisible(true); // Hace visible la ventana
        });
    }
}