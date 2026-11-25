package lab100;

import javax.swing.*; // Importa JPanel, que permite crear un área para dibujar
import java.awt.*; // Importa Graphics y Graphics2D para realizar dibujos

public class GraficoTemperatura extends JPanel { // Crea un panel personalizado para representar las temperaturas

    double[] temperaturas = new double[7]; // Crea un arreglo para almacenar las temperaturas de los siete días
    String[] dias = {"Lun", "Mar", "Mie", "Jue", "Vie", "Sab", "Dom"}; // Almacena las abreviaturas de los días que aparecerán en el eje horizontal

    boolean datosCargados = false; // Indica si ya se ingresaron temperaturas para permitir dibujar el gráfico
    public void actualizarGrafico(double[] datos) { // Recibe el arreglo con las siete temperaturas ingresadas desde la ventana

        temperaturas = datos; // Reemplaza los valores anteriores por las nuevas temperaturas recibidas
        datosCargados = true; // Indica que ya existen datos disponibles para dibujar

        repaint(); // Solicita a Swing que vuelva a ejecutar paintComponent para actualizar el gráfico
    }

    @Override
    protected void paintComponent(Graphics g) { // Método de Swing encargado de dibujar los elementos dentro del JPanel

        super.paintComponent(g); // Limpia el contenido anterior del panel antes de realizar un nuevo dibujo

        Graphics2D g2 = (Graphics2D) g; // Convierte Graphics en Graphics2D para utilizar herramientas de dibujo

        int inicioX = 55; // Establece el margen izquierdo donde comenzará el gráfico
        int inicioY = 30; // Establece el margen superior donde comenzará el gráfico

        int ancho = getWidth() - 85; // Calcula el ancho disponible del panel descontando los márgenes
        int alto = getHeight() - 90; // Calcula la altura disponible del panel descontando los márgenes

        g2.drawLine(inicioX, inicioY, inicioX, inicioY + alto); // Dibuja el eje vertical que representa las temperaturas
        g2.drawLine(inicioX, inicioY + alto, inicioX + ancho, inicioY + alto); // Dibuja el eje horizontal donde aparecerán los días

        for (int i = 0; i <= 5; i++) { // Repite seis veces para dibujar las divisiones de la escala de temperatura

            int y = inicioY + alto - (i * alto / 5); // Calcula la posición vertical de cada división desde 0 hasta 50 grados
            g2.drawLine(inicioX - 5, y, inicioX + ancho, y); // Dibuja una línea horizontal que sirve como referencia para leer el gráfico
            g2.drawString((i * 10) + "°C", 5, y + 5); // Escribe los valores de temperatura 0, 10, 20, 30, 40 y 50 °C en el eje vertical
        }

        if (!datosCargados) { // Comprueba si todavía no se han ingresado temperaturas

            g2.drawString("Ingrese las temperaturas y presione Mostrar Gráfico", inicioX + 10, inicioY + 30); // Muestra un mensaje mientras no existan datos
            return; // Termina el dibujo para evitar mostrar temperaturas que todavía no existen
        }

        for (int i = 0; i < 7; i++) { // Recorre las siete posiciones del arreglo, una por cada día de la semana
            int x = inicioX + i * ancho / 6; // Calcula la coordenada horizontal donde se ubicará el día correspondiente
            int y = inicioY + alto - (int)(temperaturas[i] * alto / 50); // Convierte la temperatura en una coordenada vertical usando una escala de 0 a 50 °C

            g2.fillOval(x - 5, y - 5, 10, 10); // Dibuja un círculo de 10 píxeles que representa la temperatura del día
            g2.drawString(dias[i], x - 10, inicioY + alto + 20); // Escribe la abreviatura del día debajo de su posición en el gráfico
            g2.drawString(temperaturas[i] + "°C", x - 15, y - 10); // Muestra el valor exacto de la temperatura encima del punto dibujado

            if (i > 0) { // Comprueba que exista un punto anterior antes de intentar conectarlo

                int anteriorX = inicioX + (i - 1) * ancho / 6; // Calcula la coordenada horizontal del día anterior
                int anteriorY = inicioY + alto - (int)(temperaturas[i - 1] * alto / 50); // Calcula la coordenada vertical de la temperatura del día anterior
                g2.drawLine(anteriorX, anteriorY, x, y); // Dibuja una línea que conecta la temperatura anterior con la temperatura actual
            }
        }
    }
}
