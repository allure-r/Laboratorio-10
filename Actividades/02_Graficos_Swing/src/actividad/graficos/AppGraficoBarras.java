package actividad.graficos;

import javax.swing.*;
import java.awt.*;

public class AppGraficoBarras extends JPanel {
    private final String[] productos = {"Producto A", "Producto B", "Producto C", "Producto D"}; // Define los nombres
    private final int[] ventas = {50, 120, 80, 150}; // Define las ventas en unidades

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia el panel antes de dibujar
        Graphics2D g2d = (Graphics2D) g; // Convierte Graphics a Graphics2D
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Activa el antialiasing
        int anchoBarra = 50; // Define el ancho de cada barra
        int espacioBarra = 20; // Define el espacio entre barras
        int margenIzquierdo = 50; // Define el margen izquierdo
        int margenInferior = 50; // Define el margen inferior
        int alturaMaxima = 200; // Define la altura máxima del gráfico
        int maxVenta = 0; // Inicializa el valor máximo de ventas

        for (int venta : ventas) {
            if (venta > maxVenta) {
                maxVenta = venta; // Actualiza el valor máximo
            }
        }

        for (int i = 0; i < productos.length; i++) {
            int alturaBarra = (int) ((double) ventas[i] / maxVenta * alturaMaxima); // Calcula la altura proporcional
            int x = margenIzquierdo + i * (anchoBarra + espacioBarra); // Calcula la posición horizontal
            int y = getHeight() - margenInferior - alturaBarra; // Calcula la posición vertical
            g2d.setColor(new Color(100, 150, 200)); // Establece el color de la barra
            g2d.fillRect(x, y, anchoBarra, alturaBarra); // Dibuja la barra
            g2d.setColor(Color.BLACK); // Establece el color de las etiquetas
            g2d.drawString(String.valueOf(ventas[i]), x + (anchoBarra / 4), y - 5); // Dibuja el valor de ventas
            g2d.drawString(productos[i], x - 5, getHeight() - margenInferior + 20); // Dibuja el nombre del producto
        }

        g2d.drawLine(margenIzquierdo, getHeight() - margenInferior, margenIzquierdo, getHeight() - margenInferior - alturaMaxima); // Dibuja el eje Y
        g2d.drawString("Ventas", margenIzquierdo - 40, getHeight() - margenInferior - alturaMaxima); // Escribe el título del eje
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Visualización de Datos - Gráfico de Barras"); // Crea la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al salir
        frame.setSize(450, 400); // Establece el tamaño de la ventana
        frame.add(new AppGraficoBarras()); // Agrega el panel de gráficos
        frame.setVisible(true); // Muestra la ventana
    }
}
