package lab100;


public class Producto { // Define la clase que representa un producto de la tienda

    private String nombre; // Almacena el nombre del producto
    private double precio; // Almacena el precio del producto, permitiendo decimales
    private int cantidadStock; // Almacena la cantidad de unidades disponibles
    private String categoria; // Almacena la categoría a la que pertenece el producto

    public Producto(String nombre, double precio, int cantidadStock, String categoria) { // Constructor que recibe los datos iniciales del producto

        this.nombre = nombre; // Guarda el nombre recibido en el atributo de la clase
        this.precio = precio; // Guarda el precio recibido en el atributo de la clase
        this.cantidadStock = cantidadStock; // Guarda la cantidad inicial de productos disponibles
        this.categoria = categoria; // Guarda la categoría recibida para el producto
    }

    public void actualizarProducto(String nombre, double precio, int cantidadStock, String categoria) { // Método que recibe los nuevos datos para actualizar el producto

        this.nombre = nombre; // Reemplaza el nombre anterior por el nuevo nombre ingresado
        this.precio = precio; // Reemplaza el precio anterior por el nuevo precio ingresado
        this.cantidadStock = cantidadStock; // Actualiza la cantidad de unidades disponibles
        this.categoria = categoria; // Reemplaza la categoría anterior por la nueva categoría
    }

    public String mostrarInformacion() { // Método que devuelve todos los datos del producto en forma de texto

        return "<html><b>PRODUCTO ACTUALIZADO</b><br>" // Inicia el formato HTML y muestra el título en negrita
             + "Nombre: " + nombre + "<br>" // Concatena el nombre y agrega un salto de línea
             + "Precio: S/ " + precio + "<br>" // Muestra el precio utilizando el símbolo de soles
             + "Stock: " + cantidadStock + "<br>" // Muestra la cantidad de productos disponibles
             + "Categoría: " + categoria + "</html>"; // Muestra la categoría y cierra el formato HTML
    }
}
