package actividad.binding;

public class Persona {
    private String nombre; // Guarda el nombre de la persona
    private int edad; // Guarda la edad de la persona
    private String sexo; // Guarda el sexo de la persona

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre; // Inicializa el nombre
        this.edad = edad; // Inicializa la edad
        this.sexo = sexo; // Inicializa el sexo
    }

    public String getNombre() {
        return nombre; // Devuelve el nombre
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Actualiza el nombre
    }

    public int getEdad() {
        return edad; // Devuelve la edad
    }

    public void setEdad(int edad) {
        this.edad = edad; // Actualiza la edad
    }

    public String getSexo() {
        return sexo; // Devuelve el sexo
    }

    public void setSexo(String sexo) {
        this.sexo = sexo; // Actualiza el sexo
    }
}
