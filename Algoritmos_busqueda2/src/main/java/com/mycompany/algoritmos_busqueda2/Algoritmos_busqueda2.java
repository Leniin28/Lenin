/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.algoritmos_busqueda2;

import java.util.Random;

public class Algoritmos_busqueda2 {

    public int Binario(int array[], int buscar) {
        int mitad, cont = 1;
        int inicio = 0;
        int fin = array.length - 1;

        while (inicio <= fin) {
            mitad = (inicio + fin) / 2;
            if (array[mitad] == buscar) {
                return cont;
            } else if (array[mitad] < buscar) {
                inicio = mitad + 1;
            } else {
                fin = mitad - 1;
            }
            cont++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Algoritmos_busqueda2 algoritmo = new Algoritmos_busqueda2();

        int limite = 100_000;        // Limite del arreglo
        int[] valores = new int[limite];// Arreglo de valores ordenados
        int[] buscar_I = new int[10];   // Arreglo de valores a buscar a la Izquierda
        int[] buscar_D = new int[10];   // Arreglo de valores a buscar a la Derecha
        int temp;                       // Agregar valores a los arreglos

        // ordenado
        for (int i = 0; i < valores.length; i++) {
            valores[i] = i + 1;
        }

        // buscar
        for (int i = 0; i < 10; i++) {
            boolean cont = true;

            // Valores a la Izquierda
            while (cont) {
                temp = random.nextInt();
                if (temp > 0 && temp < (limite / 2)) {
                    buscar_I[i] = temp;
                    cont = false;
                }
            }

            // Valores a la Derecha
            while (!cont) {
                temp = random.nextInt();
                if (temp > (limite / 2) && temp < limite) {
                    buscar_D[i] = temp;
                    cont = true;
                }
            }
        }

        // Buscar y registrar tiempo
        System.out.println("Valores a la izquierda");
        for (int valor : buscar_I) {
            long inicio = System.nanoTime(); // Tiempo inicial
            int iteraciones = algoritmo.Binario(valores, valor);
            long fin = System.nanoTime();   // Tiempo final
            System.out.printf("Valor: %d,\tIteraciones: %d,\tTiempo: %d ns\n",
                    valor, iteraciones, (fin - inicio));
        }

        System.out.println("\nValores a la derecha");
        for (int valor : buscar_D) {
            long inicio = System.nanoTime(); // Tiempo inicial
            int iteraciones = algoritmo.Binario(valores, valor);
            long fin = System.nanoTime();   // Tiempo final
            System.out.printf("Valor: %d,\tIteraciones: %d,\tTiempo: %d ns\n",
                    valor, iteraciones, (fin - inicio));
        }
    }
}
