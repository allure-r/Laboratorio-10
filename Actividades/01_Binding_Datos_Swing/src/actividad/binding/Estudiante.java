package actividad.binding;

public class Estudiante {
    private String nombre; // Guarda el nombre del estudiante
    private int edad; // Guarda la edad del estudiante
    private String carrera; // Guarda la carrera del estudiante

    public Estudiante(String nombre, int edad, String carrera) {
        this.nombre = nombre; // Inicializa el nombre
        this.edad = edad; // Inicializa la edad
        this.carrera = carrera; // Inicializa la carrera
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

    public String getCarrera() {
        return carrera; // Devuelve la carrera
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera; // Actualiza la carrera
    }
}
