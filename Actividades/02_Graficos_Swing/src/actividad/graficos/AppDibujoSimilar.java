package actividad.graficos;

import javax.swing.*;
import java.awt.*;

public class AppDibujoSimilar extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia el panel antes de dibujar
        g.setColor(Color.LIGHT_GRAY); // Establece el color del fondo
        g.fillRect(30, 30, 320, 240); // Dibuja el fondo
        g.setColor(Color.BLUE); // Establece el color del techo
        int[] xTecho = {80, 180, 280}; // Define las coordenadas X del techo
        int[] yTecho = {110, 40, 110}; // Define las coordenadas Y del techo
        g.fillPolygon(xTecho, yTecho, 3); // Dibuja el techo triangular
        g.setColor(Color.RED); // Establece el color de la casa
        g.fillRect(100, 110, 160, 130); // Dibuja la estructura de la casa
        g.setColor(Color.WHITE); // Establece el color de la puerta
        g.fillRect(165, 170, 40, 70); // Dibuja la puerta
        g.setColor(Color.YELLOW); // Establece el color de las ventanas
        g.fillRect(115, 130, 35, 30); // Dibuja la ventana izquierda
        g.fillRect(210, 130, 35, 30); // Dibuja la ventana derecha
        g.setColor(Color.BLACK); // Establece el color de los contornos y el texto
        g.drawRect(100, 110, 160, 130); // Dibuja el contorno de la casa
        g.drawString("Dibujo creado con Graphics", 90, 290); // Escribe el título
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicación similar con Graphics"); // Crea la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al salir
        frame.setSize(400, 350); // Establece el tamaño de la ventana
        frame.add(new AppDibujoSimilar()); // Agrega el panel de dibujo
        frame.setVisible(true); // Muestra la ventana
    }
}
