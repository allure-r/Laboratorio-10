package lab100;

import javax.swing.*; // Importa los componentes para crear ventanas, etiquetas, campos y botones
import java.awt.*; // Importa los diseños para organizar los componentes
import java.awt.event.*; // Importa las herramientas necesarias para detectar los clics del usuario

public class VentanaTemperatura extends JFrame { // Crea la ventana principal heredando las propiedades de JFrame

    String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"}; // Almacena los nombres de los siete días que aparecerán en la interfaz
    JTextField[] campos = new JTextField[7]; // Crea un arreglo que almacenará los siete campos de texto
    JButton btnMostrar = new JButton("Mostrar Gráfico"); // Crea el botón que permitirá visualizar las temperaturas
    GraficoTemperatura grafico = new GraficoTemperatura(); // Crea un objeto del panel personalizado donde se dibujará el gráfico

    public VentanaTemperatura() { // Constructor encargado de configurar todos los componentes de la ventana

        setTitle("Temperaturas de la Semana"); // Establece el título que aparecerá en la parte superior de la ventana
        setSize(750, 500); // Define el ancho y alto de la ventana en píxeles
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Finaliza la aplicación cuando el usuario cierra la ventana
        setLocationRelativeTo(null); // Coloca la ventana en el centro de la pantalla

        JPanel panelDatos = new JPanel(new GridLayout(7, 2, 5, 5)); // Crea un panel organizado en siete filas y dos columnas para ingresar las temperaturas

        for (int i = 0; i < 7; i++) { // Recorre las siete posiciones para crear los campos de cada día
            panelDatos.add(new JLabel(dias[i] + ":")); // Agrega una etiqueta con el nombre del día correspondiente
            campos[i] = new JTextField(); // Crea un campo de texto para ingresar la temperatura de ese día
            panelDatos.add(campos[i]); // Agrega el campo de texto al panel junto a su etiqueta
        }

        setLayout(new BorderLayout()); // Organiza la ventana en cinco regiones: norte, sur, este, oeste y centro
        add(panelDatos, BorderLayout.WEST); // Coloca el panel de ingreso de temperaturas en el lado izquierdo
        add(grafico, BorderLayout.CENTER); // Coloca el panel personalizado en el centro para visualizar el gráfico
        add(btnMostrar, BorderLayout.SOUTH); // Coloca el botón Mostrar Gráfico en la parte inferior de la ventana
        btnMostrar.addActionListener(new ActionListener() { // Registra un evento para detectar cuando el usuario presiona el botón

            @Override
            public void actionPerformed(ActionEvent e) { // Ejecuta estas instrucciones cuando se produce el clic

                try { // Inicia un bloque para controlar errores al convertir las temperaturas ingresadas

                    double[] temperaturas = new double[7]; // Crea un arreglo para almacenar los siete valores numéricos
                    for (int i = 0; i < 7; i++) { // Recorre los siete campos de texto para obtener sus temperaturas
                        temperaturas[i] = Double.parseDouble(campos[i].getText().trim()); // Obtiene el texto, elimina espacios y lo convierte en un número decimal
                        if (temperaturas[i] < 0 || temperaturas[i] > 50) { // Comprueba que la temperatura esté dentro de la escala de 0 a 50 °C
                            JOptionPane.showMessageDialog(null, "Las temperaturas deben estar entre 0 y 50 °C"); // Informa al usuario que el valor está fuera del rango permitido
                            return; // Detiene la ejecución para evitar dibujar datos incorrectos
                        }
                    }

                    grafico.actualizarGrafico(temperaturas); // Envía las siete temperaturas al panel para actualizar y dibujar el gráfico
                } catch (NumberFormatException ex) { // Captura errores cuando algún campo está vacío o contiene letras en lugar de números
                    JOptionPane.showMessageDialog(null, "Ingrese las siete temperaturas correctamente"); // Muestra un mensaje indicando que se deben completar 
                    //los campos con números válidos
                }
            }
        });

        setVisible(true); // Hace visible la ventana para que el usuario pueda ingresar las temperaturas
    }

    public static void main(String[] args) { // Método principal que inicia la ejecución de la aplicación

        new VentanaTemperatura(); // Crea un objeto de la ventana y muestra la interfaz gráfica
    }
}
