package actividad.graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class AppGraficos2D extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia el panel antes de dibujar
        Graphics2D g2d = (Graphics2D) g; // Convierte Graphics a Graphics2D
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Activa el antialiasing
        g2d.setColor(Color.GRAY); // Establece el color gris
        int rectWidth = 100; // Define el ancho del rectángulo
        int rectHeight = 50; // Define la altura del rectángulo
        g2d.fillRect(50, 50, rectWidth, rectHeight); // Dibuja el rectángulo original
        AffineTransform originalTransform = g2d.getTransform(); // Guarda la transformación original

        g2d.translate(200, 0); // Traslada el dibujo hacia la derecha
        g2d.setColor(Color.BLUE); // Establece el color azul
        g2d.fillRect(50, 50, rectWidth, rectHeight); // Dibuja el rectángulo trasladado
        g2d.setTransform(originalTransform); // Restaura la transformación original

        g2d.translate(0, 150); // Desplaza el dibujo hacia abajo
        g2d.rotate(Math.toRadians(45), 100, 75); // Rota 45 grados alrededor del centro
        g2d.setColor(Color.GREEN); // Establece el color verde
        g2d.fillRect(50, 50, rectWidth, rectHeight); // Dibuja el rectángulo rotado
        g2d.setTransform(originalTransform); // Restaura la transformación original

        g2d.translate(200, 150); // Desplaza el dibujo hacia la derecha y abajo
        g2d.scale(1.5, 0.5); // Escala los ejes X e Y
        g2d.setColor(Color.ORANGE); // Establece el color naranja
        g2d.fillRect(50, 50, rectWidth, rectHeight); // Dibuja el rectángulo escalado
        g2d.setTransform(originalTransform); // Restaura la transformación original

        g2d.translate(0, 300); // Desplaza el dibujo hacia abajo
        g2d.shear(0.5, 0); // Aplica un sesgado horizontal
        g2d.setColor(Color.MAGENTA); // Establece el color magenta
        g2d.fillRect(50, 50, rectWidth, rectHeight); // Dibuja el rectángulo sesgado
        g2d.setTransform(originalTransform); // Restaura la transformación original
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Transformaciones con Graphics2D"); // Crea la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al salir
        frame.setSize(500, 550); // Establece el tamaño de la ventana
        frame.add(new AppGraficos2D()); // Agrega el panel de dibujo
        frame.setVisible(true); // Muestra la ventana
    }
}
