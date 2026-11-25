package actividad.binding;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppBindingEstudiante {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Binding de Datos - Estudiante"); // Crea la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al salir
        frame.setSize(360, 230); // Establece el tamaño de la ventana
        frame.setLayout(new FlowLayout()); // Organiza los componentes en flujo

        Estudiante estudiante = new Estudiante("Ana Torres", 20, "Ingeniería de Sistemas"); // Crea el modelo similar
        JTextField nombreField = new JTextField(estudiante.getNombre(), 18); // Muestra el nombre inicial
        JTextField edadField = new JTextField(String.valueOf(estudiante.getEdad()), 18); // Muestra la edad inicial
        JTextField carreraField = new JTextField(estudiante.getCarrera(), 18); // Muestra la carrera inicial
        JButton button = new JButton("Actualizar Estudiante"); // Crea el botón de actualización
        JLabel resultado = new JLabel("Modifique los datos y actualice."); // Presenta el resultado en la interfaz

        button.addActionListener(new ActionListener() { // Escucha el clic del botón
            @Override
            public void actionPerformed(ActionEvent e) {
                estudiante.setNombre(nombreField.getText()); // Actualiza el nombre del modelo
                try {
                    estudiante.setEdad(Integer.parseInt(edadField.getText())); // Actualiza la edad del modelo
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese una edad válida."); // Informa si la edad no es numérica
                    return; // Evita actualizar con una edad incorrecta
                }
                estudiante.setCarrera(carreraField.getText()); // Actualiza la carrera del modelo
                resultado.setText("Nombre: " + estudiante.getNombre() + " | Edad: " + estudiante.getEdad() + " | Carrera: " + estudiante.getCarrera()); // Muestra el modelo actualizado
                System.out.println(resultado.getText()); // Verifica el resultado en consola
            }
        });

        frame.add(new JLabel("Nombre:")); // Agrega la etiqueta del nombre
        frame.add(nombreField); // Agrega el campo del nombre
        frame.add(new JLabel("Edad:")); // Agrega la etiqueta de la edad
        frame.add(edadField); // Agrega el campo de la edad
        frame.add(new JLabel("Carrera:")); // Agrega la etiqueta de la carrera
        frame.add(carreraField); // Agrega el campo de la carrera
        frame.add(button); // Agrega el botón
        frame.add(resultado); // Agrega la etiqueta de resultado
        frame.setVisible(true); // Muestra la ventana
    }
}
