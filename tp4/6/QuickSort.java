public class QuickSort {
    // Función principal para iniciar el ordenamiento Quicksort recursivo
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // Función recursiva para realizar el ordenamiento Quicksort
    private static void quickSort(int[] arr, int inicio, int fin) {
        // Trivial case: si el subarreglo tiene 0 o 1 elemento, ya está ordenado
        if (inicio >= fin) {
            return;
        }

        // Seleccionamos un pivote y particionamos el arreglo alrededor de él
        int indicePivote = partition(arr, inicio, fin);

        // Llamadas recursivas para ordenar los subarreglos antes y después del pivote
        quickSort(arr, inicio, indicePivote - 1);
        quickSort(arr, indicePivote + 1, fin);
    }

    // Función auxiliar para particionar el arreglo y devolver el índice del pivote
    private static int partition(int[] arr, int inicio, int fin) {
        // Seleccionamos el último elemento como pivote
        int pivote = arr[fin];
        int i = inicio - 1; // Índice del elemento más pequeño

        // Recorremos el subarreglo
        for (int j = inicio; j < fin; j++) {
            // Si el elemento actual es menor o igual al pivote, lo movemos al subarreglo de
            // menores
            if (arr[j] <= pivote) {
                i++;
                swap(arr, i, j);
            }
        }

        // Movemos el pivote a su posición correcta
        swap(arr, i + 1, fin);
        return i + 1;
    }

    // Función auxiliar para intercambiar dos elementos en el arreglo
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Función para imprimir el arreglo
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] arr = { 6, 2, 8, 3, 1, 5, 7, 4 };
        System.out.println("Arreglo original:");
        printArray(arr);

        sort(arr);

        System.out.println("Arreglo ordenado:");
        printArray(arr);
    }
}
