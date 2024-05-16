package metodosjavautil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Crear un arreglo de enteros
        int[] arreglo = { 5, 3, 9, 2, 7 };

        // Imprimir el arreglo original
        System.out.println("Arreglo original: " + Arrays.toString(arreglo));

        // Probar el método equals para comparar dos arreglos
        int[] arreglo2 = { 5, 3, 9, 2, 7 };
        boolean sonIguales = Arrays.equals(arreglo, arreglo2);
        System.out.println("¿Los arreglos son iguales? " + sonIguales);

        // Probar el método fill para llenar el arreglo con un valor específico
        Arrays.fill(arreglo, 0);
        System.out.println("Arreglo llenado con ceros: " + Arrays.toString(arreglo));

        // Probar el método copyOf para copiar el arreglo original a uno nuevo de tamaño
        // n
        int[] copiaArreglo = Arrays.copyOf(arreglo2, 3);
        System.out.println("Copia del arreglo con 3 elementos: " + Arrays.toString(copiaArreglo));

        // Probar el método copyOfRange para copiar un rango de elementos del arreglo
        // original a uno nuevo
        int[] copiaRangoArreglo = Arrays.copyOfRange(arreglo2, 1, 4);
        System.out.println("Copia del rango [1, 4) del arreglo original: " + Arrays.toString(copiaRangoArreglo));

        // Probar el método toString para convertir el arreglo en una cadena de texto
        String cadenaArreglo = Arrays.toString(arreglo2);
        System.out.println("Arreglo como cadena de texto: " + cadenaArreglo);

        // Probar el método sort para ordenar el arreglo
        Arrays.sort(arreglo2);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo2));

        // Probar el método binarySearch para buscar un elemento en el arreglo ordenado
        int indiceElemento = Arrays.binarySearch(arreglo2, 5);
        System.out.println("Índice del elemento 5 en el arreglo ordenado: " + indiceElemento);
    }
}
