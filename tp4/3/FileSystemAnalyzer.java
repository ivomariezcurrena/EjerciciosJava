import java.io.File;

public class FileSystemAnalyzer {
    public static void analizarDirectorio(File directorio) {
        // Verificar si el directorio es válido
        if (!directorio.isDirectory()) {
            System.out.println("La ruta proporcionada no es un directorio válido.");
            return;
        }

        // Inicializar variables para el total de bytes, cantidad de directorios y cantidad de archivos
        long totalBytes = 0;
        int cantidadDirectorios = 0;
        int cantidadArchivos = 0;

        // Obtener la lista de archivos y directorios en el directorio actual
        File[] archivos = directorio.listFiles();

        // Iterar sobre los archivos y directorios
        for (File archivo : archivos) {
            // Verificar si es un directorio
            if (archivo.isDirectory()) {
                // Incrementar la cantidad de directorios
                cantidadDirectorios++;
                // Recursivamente analizar el directorio
                analizarDirectorio(archivo);
            } else {
                // Es un archivo, incrementar la cantidad de archivos y sumar el tamaño en bytes
                cantidadArchivos++;
                totalBytes += archivo.length();
            }
        }

        // Imprimir resultados para el directorio actual
        System.out.println("Directorio: " + directorio.getAbsolutePath());
        System.out.println("Total de bytes utilizados: " + totalBytes + " bytes");
        System.out.println("Cantidad de directorios: " + cantidadDirectorios);
        System.out.println("Cantidad de archivos: " + cantidadArchivos);
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        // Ruta del directorio a analizar (puedes cambiarla según tu necesidad)
        String rutaDirectorio = "/ruta/al/directorio";
        File directorio = new File(rutaDirectorio);

        // Llamar a la función recursiva para analizar el directorio
        analizarDirectorio(directorio);
    }
}
