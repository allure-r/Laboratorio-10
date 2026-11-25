package actividad.graficos;

import javax.swing.*;
import java.awt.*;

public class AppGraficos extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia el panel antes de dibujar
        g.setColor(Color.BLUE); // Establece el color azul
        g.drawLine(10, 10, 100, 100); // Dibuja una línea
        g.setColor(Color.RED); // Establece el color rojo
        g.drawRect(50, 50, 100, 50); // Dibuja un rectángulo
        g.setColor(Color.GREEN); // Establece el color verde
        g.drawOval(170, 50, 100, 50); // Dibuja un óvalo
        g.setColor(Color.ORANGE); // Establece el color naranja
        g.fillOval(200, 150, 50, 50); // Dibuja un círculo relleno
        g.setColor(Color.BLACK); // Establece el color negro
        g.drawString("Ejemplo de Gráficos en Swing", 10, 230); // Dibuja un texto
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Gráficos"); // Crea la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al salir
        frame.setSize(400, 300); // Establece el tamaño de la ventana
        frame.add(new AppGraficos()); // Agrega el panel de dibujo
        frame.setVisible(true); // Muestra la ventana
    }
}
