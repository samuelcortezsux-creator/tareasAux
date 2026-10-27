package comp.agrega;

public class Aplicacion {
    private String nombre;
    private int tamanio;

    public Aplicacion(String nombre, int tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void mostrar() {
        System.out.println("    [App] Nombre: " + nombre + ", Tamaño: " + tamanio);
    }
}