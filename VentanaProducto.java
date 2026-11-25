package lab100;


import javax.swing.*; // Importa los componentes necesarios para crear ventanas, botones y etiquetas
import java.awt.*; // Importa las herramientas para organizar los componentes de la interfaz
import java.awt.event.*; // Importa las clases necesarias para detectar los eventos del usuario

public class VentanaProducto extends JFrame { // Crea la ventana principal heredando las propiedades de JFrame

    JTextField txtNombre = new JTextField(); // Campo donde el usuario escribirá el nombre del producto
    JTextField txtPrecio = new JTextField(); // Campo donde el usuario ingresará el precio
    JTextField txtStock = new JTextField(); // Campo donde el usuario ingresará la cantidad disponible
    JTextField txtCategoria = new JTextField(); // Campo donde el usuario escribirá la categoría

    JButton btnActualizar = new JButton("Actualizar Producto"); // Crea el botón que permitirá actualizar los datos

    JLabel lblInformacion = new JLabel("Aquí aparecerá el producto"); // Etiqueta donde se mostrará la información actualizada

    Producto producto = new Producto("", 0, 0, ""); // Crea un objeto Producto con valores iniciales vacíos o en cero

    public VentanaProducto() { // Constructor que configura y muestra la ventana

        setTitle("Gestión de Productos"); // Establece el título que aparecerá en la parte superior
        setSize(500, 350); // Define el ancho y alto de la ventana en píxeles
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra completamente el programa al cerrar la ventana
        setLocationRelativeTo(null); // Ubica la ventana en el centro de la pantalla

        setLayout(new GridLayout(6, 2, 5, 5)); // Organiza los componentes en 6 filas y 2 columnas con separación de 5 píxeles

        add(new JLabel("Nombre:")); // Agrega una etiqueta para identificar el campo del nombre
        add(txtNombre); // Coloca el campo donde se escribirá el nombre del producto

        add(new JLabel("Precio:")); // Agrega una etiqueta para identificar el campo del precio
        add(txtPrecio); // Coloca el campo donde se escribirá el precio del producto

        add(new JLabel("Cantidad en stock:")); // Agrega una etiqueta para identificar la cantidad disponible
        add(txtStock); // Coloca el campo donde se escribirá el stock del producto

        add(new JLabel("Categoría:")); // Agrega una etiqueta para identificar la categoría
        add(txtCategoria); // Coloca el campo donde se escribirá la categoría del producto

        add(new JLabel("")); // Agrega un espacio vacío para mantener la distribución de la interfaz
        add(btnActualizar); // Agrega el botón que ejecutará la actualización del producto

        add(new JLabel("Información:")); // Agrega un texto para identificar la sección de resultados
        add(lblInformacion); // Agrega la etiqueta que mostrará los datos del producto

        btnActualizar.addActionListener(new ActionListener() { // Registra un evento para detectar cuando se presiona el botón

            @Override
            public void actionPerformed(ActionEvent e) { // Ejecuta estas instrucciones cuando el usuario hace clic

                try { // Inicia un bloque para controlar posibles errores en los datos ingresados

                    String nombre = txtNombre.getText().trim(); // Obtiene el nombre escrito y elimina espacios al inicio y al final
                    double precio = Double.parseDouble(txtPrecio.getText().trim()); // Convierte el precio ingresado de texto a número decimal
                    int stock = Integer.parseInt(txtStock.getText().trim()); // Convierte la cantidad ingresada de texto a número entero
                    String categoria = txtCategoria.getText().trim(); // Obtiene la categoría escrita y elimina espacios innecesarios

                    if (nombre.isEmpty() || categoria.isEmpty() || precio < 0 || stock < 0) { // Comprueba que los textos no estén vacíos y que los números no sean negativos

                        JOptionPane.showMessageDialog(null, "Complete los campos correctamente"); // Muestra un mensaje si los datos no son válidos
                        return; // Detiene la actualización mientras existan datos incorrectos
                    }

                    producto.actualizarProducto(nombre, precio, stock, categoria); // Envía los cuatro datos al objeto para actualizar sus atributos

                    lblInformacion.setText(producto.mostrarInformacion()); // Obtiene la información actualizada y la muestra dentro del JLabel

                } catch (NumberFormatException ex) { // Captura errores cuando el precio o el stock contienen letras o están vacíos

                    JOptionPane.showMessageDialog(null, "Ingrese un precio y stock válidos"); // Informa al usuario que debe ingresar números correctos
                }
            }
        });

        setVisible(true); // Hace visible la ventana para que el usuario pueda utilizarla
    }

    public static void main(String[] args) { // Método principal desde donde comienza la ejecución del programa

        new VentanaProducto(); // Crea un objeto de la ventana y ejecuta la aplicación
    }
}
