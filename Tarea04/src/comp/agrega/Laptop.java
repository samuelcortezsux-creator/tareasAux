package comp.agrega;

public class Laptop {
    private String modelo;
    private int cantApps;
    private Aplicacion[] apps;
    private Pantalla pantalla;

    public Laptop(String modelo, Pantalla pantalla) {
        this.modelo = modelo;
        this.pantalla = pantalla;
        this.cantApps = 0;
        this.apps = new Aplicacion[50];
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantApps() {
        return cantApps;
    }

    public void setCantApps(int cantApps) {
        this.cantApps = cantApps;
    }

    public Aplicacion[] getApps() {
        return apps;
    }

    public Pantalla getPantalla() {
        return pantalla;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    public boolean agregarAplicacion(Aplicacion app) {
        if (cantApps < 50) {
            apps[cantApps] = app;
            cantApps++;
            return true;
        }
        return false;
    }

    public void eliminarTodasApps() {
        for (int i = 0; i < cantApps; i++) {
            apps[i] = null;
        }
        cantApps = 0;
    }

    public void ordenarApps() {
        // Ordenamiento burbuja: decreciente por tamaño (peso). Si hay empate, por nombre ascendente.
        for (int i = 0; i < cantApps - 1; i++) {
            for (int j = i + 1; j < cantApps; j++) {
                boolean cambiar = false;
                if (apps[j].getTamanio() > apps[i].getTamanio()) {
                    cambiar = true;
                } else if (apps[j].getTamanio() == apps[i].getTamanio()) {
                    if (apps[j].getNombre().compareTo(apps[i].getNombre()) < 0) {
                        cambiar = true;
                    }
                }
                if (cambiar) {
                    Aplicacion aux = apps[i];
                    apps[i] = apps[j];
                    apps[j] = aux;
                }
            }
        }
    }

    public void mostrar() {
        System.out.println("Laptop Modelo: " + modelo + ", Cantidad de Apps: " + cantApps);
        if (pantalla != null) {
            pantalla.mostrar();
        }
        System.out.println("Aplicaciones:");
        for (int i = 0; i < cantApps; i++) {
            apps[i].mostrar();
        }
        System.out.println("");
    }
}