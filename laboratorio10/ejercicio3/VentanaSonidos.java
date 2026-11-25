package laboratorio10.ejercicio3;

// Importamos las clases necesarias para crear la ventana y sus componentes
import javax.swing.*;
import java.awt.*;

public class VentanaSonidos extends JFrame {

    private final ReproductorSonido reproductor; // Instancia encargada de reproducir los sonidos

    // Constructor de la ventana
    public VentanaSonidos() {
        this.reproductor = new ReproductorSonido(); // Crea el reproductor de sonidos
        configurarVentana(); // Configura las propiedades de la ventana
        inicializarComponentes(); // Agrega los componentes a la ventana
    }

    // Método para configurar las propiedades de la ventana
    private void configurarVentana() {
        setTitle("Reproductor de Efectos de Sonido"); // Establece el título de la ventana
        setSize(450, 190); // Define el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicacion al cerrar la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new BorderLayout(10, 10)); // Organiza los componentes en diferentes regiones
    }

    // Método para crear y organizar los componentes
    private void inicializarComponentes() {
        JLabel titulo = new JLabel("Selecciona un efecto de sonido", SwingConstants.CENTER); // Crea el título de la ventana
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 17)); // Establece el tipo y tamaño de letra
        titulo.setBorder(BorderFactory.createEmptyBorder(18, 10, 5, 10)); // Agrega espacio alrededor del título
        add(titulo, BorderLayout.NORTH); // Coloca el título en la parte superior
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 15)); // Crea un panel para los botones
        panelBotones.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 15)); // Agrega espacio alrededor del panel
        
        // Creamos los botones para cada efecto de sonido
        JButton btnAplausos = estilizarBoton(new JButton("Aplausos"));
        JButton btnCampana = estilizarBoton(new JButton("Campana"));
        JButton btnExplosion = estilizarBoton(new JButton("Explosión"));

        // Asignamos la reproduccion de cada sonido al botón correspondiente
        btnAplausos.addActionListener(e -> reproductor.reproducir("aplausos.wav"));
        btnCampana.addActionListener(e -> reproductor.reproducir("campanas.wav"));
        btnExplosion.addActionListener(e -> reproductor.reproducir("explosiones.wav"));

        // Agregamos los botones al panel
        panelBotones.add(btnAplausos);
        panelBotones.add(btnCampana);
        panelBotones.add(btnExplosion);

        add(panelBotones, BorderLayout.CENTER); // Colocamos el panel en el centro de la ventana

    }

    // Método para establecer el estilo de los botones
    private JButton estilizarBoton(JButton boton) {
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Establece el tipo y tamaño de letra
        boton.setPreferredSize(new Dimension(115, 38)); // Define el tamaño de los botones
        boton.setFocusPainted(false); // Quita el borde de enfoque al seleccionar el botón

        return boton; // Devuelve el botón con el estilo aplicado
    }

}