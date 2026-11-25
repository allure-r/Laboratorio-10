package laboratorio10.ejercicio4;

// Importamos las clases necesarias para crear la ventana y sus componentes
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaMusica extends JFrame {

    private static final String RUTA_MUSICA = "pista_musica.wav"; // Guarda la ruta del archivo de música
    private final ReproductorMusica reproductor; // Instancia encargada de controlar la reproducción

    // Constructor de la ventana
    public VentanaMusica() {
        this.reproductor = new ReproductorMusica(); // Crea el reproductor de música
        configurarVentana(); // Configura las propiedades de la ventana
        inicializarComponentes(); // Agrega los componentes a la ventana
    }

    // Método para configurar las propiedades de la ventana
    private void configurarVentana() {
        setTitle("Reproductor de Música"); // Establece el título de la ventana
        setSize(450, 190); // Define el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new BorderLayout(10, 10)); // Organiza los componentes en diferentes regiones
        getContentPane().setBackground(new Color(240, 244, 248)); // Establece el color de fondo
        
        // Liberamos los recursos del reproductor al cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                reproductor.cerrarClipActual(); // Cierra el clip de música actual
            }
        });
    }

    // Método para crear y organizar los componentes
    private void inicializarComponentes() {
        JLabel titulo = new JLabel("Control de Pista de Música", SwingConstants.CENTER); // Crea el título de la ventana
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 17)); // Establece el tipo y tamaño de letra
        titulo.setForeground(new Color(30, 41, 59)); // Establece el color del texto
        titulo.setBorder(BorderFactory.createEmptyBorder(18, 10, 5, 10)); // Agrega espacio alrededor del título
        add(titulo, BorderLayout.NORTH); // Coloca el título en la parte superior
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 15)); // Crea un panel para los botones
        panelBotones.setBackground(new Color(240, 244, 248)); // Establece el color de fondo del panel
        panelBotones.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 15)); // Agrega espacio alrededor del panel

        // Creamos los botones con sus respectivos colores
        JButton btnReproducir = estilizarBoton(new JButton("Reproducir"), new Color(34, 197, 94));
        JButton btnPausar = estilizarBoton(new JButton("Pausar"), new Color(245, 158, 11));
        JButton btnReanudar = estilizarBoton(new JButton("Reanudar"), new Color(59, 130, 246));

        // Asignamos una acción a cada botón
        btnReproducir.addActionListener(e -> reproductor.reproducir(RUTA_MUSICA));
        btnPausar.addActionListener(e -> reproductor.pausar());
        btnReanudar.addActionListener(e -> reproductor.reanudar());

        // Agregamos los botones al panel
        panelBotones.add(btnReproducir);
        panelBotones.add(btnPausar);
        panelBotones.add(btnReanudar);

        add(panelBotones, BorderLayout.CENTER); // Coloca el panel en el centro de la ventana

    }

    // Método para establecer el estilo de los botones
    private JButton estilizarBoton(JButton boton, Color colorFondo) {
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13)); // Establece el tipo y tamaño de letra
        boton.setBackground(colorFondo); // Establece el color de fondo del botón
        boton.setForeground(Color.WHITE); // Establece el color del texto
        boton.setOpaque(true); // Permite mostrar el color de fondo
        boton.setContentAreaFilled(true); // Rellena el area del botón
        boton.setFocusPainted(false); // Quita el borde de enfoque al seleccionar el botón
        boton.setPreferredSize(new Dimension(115, 38)); // Define el tamaño del botón
        
        return boton; // Devuelve el botón con el estilo aplicado
    }
}