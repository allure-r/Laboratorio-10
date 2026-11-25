package actividad.binding;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppBindingPersona {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Binding de Datos"); // Crea la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al salir
        frame.setSize(360, 250); // Establece el tamaño de la ventana
        frame.setLayout(new FlowLayout()); // Organiza los componentes en flujo

        Persona persona = new Persona("John Doe", 30, "Masculino"); // Crea el modelo de datos
        JTextField nombreField = new JTextField(persona.getNombre(), 15); // Muestra el nombre inicial
        JTextField edadField = new JTextField(String.valueOf(persona.getEdad()), 15); // Muestra la edad inicial
        JTextField sexoField = new JTextField(persona.getSexo(), 15); // Muestra el sexo inicial
        JButton button = new JButton("Actualizar Modelo"); // Crea el botón de actualización

        button.addActionListener(new ActionListener() { // Escucha el clic del botón
            @Override
            public void actionPerformed(ActionEvent e) {
                persona.setNombre(nombreField.getText()); // Envía el nombre de la vista al modelo
                try {
                    int edad = Integer.parseInt(edadField.getText()); // Convierte la edad ingresada
                    persona.setEdad(edad); // Actualiza la edad del modelo
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese una edad válida."); // Informa si la edad no es numérica
                    return; // Evita mostrar datos incompletos
                }
                persona.setSexo(sexoField.getText()); // Actualiza el sexo del modelo
                System.out.println("Modelo actualizado:"); // Muestra el resultado en consola
                System.out.println("Nombre: " + persona.getNombre()); // Imprime el nombre actualizado
                System.out.println("Edad: " + persona.getEdad()); // Imprime la edad actualizada
                System.out.println("Sexo: " + persona.getSexo()); // Imprime el sexo actualizado
            }
        });

        frame.add(new JLabel("Nombre:")); // Agrega la etiqueta del nombre
        frame.add(nombreField); // Agrega el campo del nombre
        frame.add(new JLabel("Edad:")); // Agrega la etiqueta de la edad
        frame.add(edadField); // Agrega el campo de la edad
        frame.add(new JLabel("Sexo:")); // Agrega la etiqueta del sexo
        frame.add(sexoField); // Agrega el campo del sexo
        frame.add(button); // Agrega el botón de actualización
        frame.setVisible(true); // Muestra la ventana
    }
}
