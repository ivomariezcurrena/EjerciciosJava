public class Main {
    public static void main(String[] args) {
        // Crear una lista de tipo Integer con capacidad para 5 elementos
        Lista<Integer> lista = new Lista<>(5);

        // Agregar elementos a la lista
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);
        lista.add(50);

        // Imprimir la lista antes de remover elementos
        System.out.println("Lista antes de remover elementos:");
        System.out.println(lista);

        // Remover un elemento por valor
        Integer elementoRemovido = lista.remove(20);
        System.out.println("\nElemento removido por valor: " + elementoRemovido);

        // Imprimir la lista después de remover elementos
        System.out.println("\nLista después de remover elementos por valor:");
        System.out.println(lista);

        // Remover un elemento por posición
        elementoRemovido = lista.removeP(0);
        System.out.println("\nElemento removido por posición: " + elementoRemovido);

        // Imprimir la lista final después de remover elementos por posición
        System.out.println("\nLista final después de remover elementos por posición:");
        System.out.println(lista);

        // Agrega en posicion
        lista.add(1, 10);
        System.out.println("\nLista final después de agregar elementos por posición:");
        System.out.println(lista);
    }
}
