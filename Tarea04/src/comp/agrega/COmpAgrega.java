package comp.agrega;

import java.util.Scanner;

public class COmpAgrega {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Instanciar N objetos Laptop en un vector.
        System.out.print("Ingrese la cantidad de laptops (N): ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        Laptop[] laptops = new Laptop[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Datos para la Laptop " + (i + 1) + " ---");
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();

            System.out.print("Tipo de pantalla (ej. LED, IPS): ");
            String tipoPantalla = scanner.nextLine();
            System.out.print("Ancho de pantalla: ");
            int ancho = scanner.nextInt();
            System.out.print("Alto de pantalla: ");
            int alto = scanner.nextInt();
            scanner.nextLine(); 

            Pantalla pantalla = new Pantalla(tipoPantalla, ancho, alto);
            laptops[i] = new Laptop(modelo, pantalla);

            System.out.print("¿Cuántas aplicaciones desea agregar inicialmente a esta laptop? (max 50): ");
            int numApps = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < numApps; j++) {
                System.out.println("  App " + (j + 1) + ":");
                System.out.print("    Nombre: ");
                String nombreApp = scanner.nextLine();
                System.out.print("    Tamaño (peso): ");
                int tamanioApp = scanner.nextInt();
                scanner.nextLine();

                laptops[i].agregarAplicacion(new Aplicacion(nombreApp, tamanioApp));
            }
        }

        System.out.println("LISTA DE LAPTOPS INICIALES");
        for (int i = 0; i < n; i++) {
            laptops[i].mostrar();
        }

        // b. Mostrar a la laptop que tenga más aplicaciones (antes de d)
        System.out.println("\n[b] Laptop con más aplicaciones (ANTES de eliminar):");
        mostrarLaptopConMasApps(laptops);

        // c. Agregar una aplicación a la laptop de modelo X.
        System.out.println("\n[c] Agregar una aplicación a una laptop de modelo X:");
        System.out.print("Ingrese el modelo X de la laptop a buscar: ");
        String modeloX = scanner.nextLine();
        System.out.print("Nombre de la nueva aplicación: ");
        String nuevoNombreApp = scanner.nextLine();
        System.out.print("Tamaño de la nueva aplicación: ");
        int nuevoTamanio = scanner.nextInt();
        scanner.nextLine();

        boolean encontradaC = false;
        for (int i = 0; i < n; i++) {
            if (laptops[i].getModelo().equalsIgnoreCase(modeloX)) {
                boolean agregado = laptops[i].agregarAplicacion(new Aplicacion(nuevoNombreApp, nuevoTamanio));
                if (agregado) {
                    System.out.println("¡Aplicación agregada exitosamente a la laptop " + modeloX + "!");
                } else {
                    System.out.println("La laptop " + modeloX + " ya alcanzó el límite de 50 aplicaciones.");
                }
                encontradaC = true;
                break;
            }
        }
        if (!encontradaC) {
            System.out.println("No se encontró ninguna laptop con el modelo " + modeloX);
        }

        // d. Eliminar todas las aplicaciones de la laptop con pantalla de ancho Y.
        System.out.println("\n[d] Eliminar todas las aplicaciones de la laptop con pantalla de ancho Y:");
        System.out.print("Ingrese el ancho Y de la pantalla: ");
        int anchoY = scanner.nextInt();
        scanner.nextLine();

        boolean encontradaD = false;
        for (int i = 0; i < n; i++) {
            if (laptops[i].getPantalla().getAncho() == anchoY) {
                laptops[i].eliminarTodasApps();
                System.out.println("Se eliminaron todas las aplicaciones de la laptop modelo: " + laptops[i].getModelo());
                encontradaD = true;
            }
        }
        if (!encontradaD) {
            System.out.println("No se encontró ninguna laptop con pantalla de ancho " + anchoY);
        }

        // e. Mostrar a la laptop que tiene más aplicaciones (después de d)
        System.out.println("\n[e] Laptop con más aplicaciones (DESPUÉS de eliminar):");
        mostrarLaptopConMasApps(laptops);

        // f. Ordenar de forma decreciente (en cuanto al peso, si hay empate por nombre) las aplicaciones de cada laptop.
        System.out.println("\n[f] Ordenando las aplicaciones de cada laptop...");
        for (int i = 0; i < n; i++) {
            laptops[i].ordenarApps();
        }

        System.out.println("LISTA FINAL DE LAPTOPS");
        for (int i = 0; i < n; i++) {
            laptops[i].mostrar();
        }

        scanner.close();
    }

    public static void mostrarLaptopConMasApps(Laptop[] laptops) {
        if (laptops == null || laptops.length == 0) return;
        Laptop maxLaptop = laptops[0];
        for (int i = 1; i < laptops.length; i++) {
            if (laptops[i].getCantApps() > maxLaptop.getCantApps()) {
                maxLaptop = laptops[i];
            }
        }
        System.out.println("-> La laptop con más aplicaciones es el modelo: " + maxLaptop.getModelo() + " con " + maxLaptop.getCantApps() + " aplicaciones.");
        maxLaptop.mostrar();
    }
}