package comp.agrega;

public class Pantalla {
    private String tipo;
    private int ancho;
    private int alto;

    public Pantalla(String tipo, int ancho, int alto) {
        this.tipo = tipo;
        this.ancho = ancho;
        this.alto = alto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void mostrar() {
        System.out.println("  [Pantalla] Tipo: " + tipo + ", Ancho: " + ancho + ", Alto: " + alto);
    }
}