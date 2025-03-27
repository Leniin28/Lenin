

package archivoleer1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger



public class ArchivoLeer1 {
    
    private static class Producto {
        String nombre;
        int precio;

        Producto(String nombre, int precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
    }
    
    private static class Producto[
            String nombre;
int precio
        ]

    
    private static class Nodo {
        Producto producto;
        Nodo siguiente;

        Nodo(Producto producto) {
            this.producto = producto;
            this.siguiente = null;
        }
    }

    private static class Cola {
        private Nodo frente;
        private Nodo finalCola;

        Cola() {
            this.frente = null;
            this.finalCola = null;
        }

        public void enqueue(Producto producto) {
            Nodo nuevoNodo = new Nodo(producto);
            if (finalCola == null) {
                frente = finalCola = nuevoNodo;
            } else {
                finalCola.siguiente = nuevoNodo;
                finalCola = nuevoNodo;
            }
        }

        public boolean estaVacia() {
            return frente == null;
        }

        public void mostrar() {
            if (estaVacia()) {
                System.out.println("No hay productos en esta cola.");
            } else {
                Nodo actual = frente;
                while (actual != null) {
                    System.out.println(actual.producto.nombre + " - $" + actual.producto.precio);
                    actual = actual.siguiente;
                }
            }
        }
    }


    public static void main(String[] args) {
        File miArchivo;
        FileReader leer;
        String cadena;
        
        miArchivo = new File("Producto.txt");
        
        Cola cola1 = new Cola();  // Precios entre 0 y 1000
        Cola cola2 = new Cola();  // Precios entre 1001 y 10,000
        Cola cola3 = new Cola();  // Precios entre 10,001 y 100,000

        try {
            leer = new FileReader(miArchivo);

            BufferedReader almacenamiento = new BufferedReader(leer);

            cadena = "";
            while (cadena != null) {
                try {
                    cadena = almacenamiento.readLine();
                    if (cadena != null) {
                        String[] partes = cadena.split(","); 
                        String nombre = partes[0].trim();
                        int precio = Integer.parseInt(partes[1].trim());

                        Producto producto = new Producto(nombre, precio);
                        if (precio >= 0 && precio <= 1000) {
                            cola1.enqueue(producto);
                        } else if (precio >= 1001 && precio <= 10000) {
                            cola2.enqueue(producto);
                        } else if (precio >= 10001 && precio <= 100000) {
                            cola3.enqueue(producto);
                        } else {
                            System.out.println("Producto " + nombre + " tiene un precio fuera del rango.");
                        }
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArchivoLeer1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                almacenamiento.close();
                leer.close();
            } catch (IOException ex) {
                Logger.getLogger(ArchivoLeer1.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoLeer1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Cola 1 (precios entre 0 y 1000):");
        cola1.mostrar();
        System.out.println("\nCola 2 (precios entre 1001 y 10,000):");
        cola2.mostrar();
        System.out.println("\nCola 3 (precios entre 10,001 y 100,000):");
        cola3.mostrar();
    
    }
}
