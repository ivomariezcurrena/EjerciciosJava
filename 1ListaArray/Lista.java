public class Lista<E> {

    private E lista[];
    private int indice;
    private final int MAXELEM;

    @SuppressWarnings("unchecked")
    public Lista(int n) {
        lista = (E[]) new Object[n];
        MAXELEM = n;
        indice = 0;
    }

    /* Agrega un elemento al final de la lista */
    public void add(E e) throws IndexOutOfBoundsException {
        if (indice == MAXELEM)
            throw new IndexOutOfBoundsException("Lista llena");
        lista[indice++] = e;
    }

    /* Agrega un elemento a la lista en la posicin p */
    public void add(int p, E e) throws IndexOutOfBoundsException {
        if (p < 0 || p >= indice)
            throw new IndexOutOfBoundsException("Indice invalido: " + p);
        if (indice == MAXELEM) { // Verifica si la lista está llena
            throw new IndexOutOfBoundsException("Lista llena");
        }
        // Desplaza los elementos hacia la derecha para hacer espacio para el nuevo
        // elemento
        for (int i = indice; i > p; i--) {
            lista[i] = lista[i - 1];
        }
        lista[p] = e;
        indice++;
    }

    /* Retorna el elemento que se encuentra en p */
    public E get(int p) throws IndexOutOfBoundsException {
        if (p < 0 || p >= indice)
            throw new IndexOutOfBoundsException("Indice invalido: " + p);
        return lista[p];
    }

    /* Remueve el elemento E de la lista. Retorna null sino se encuentra */
    public E remove(E e) {
        boolean encontrado = false;
        int i;

        for (i = 0; i < indice; i++) {
            if (lista[i].equals(e)) {
                encontrado = true;
                break;
            }
        }

        if (!encontrado)
            return null;
        return removeP(i);
    }

    /* Remueve el elemento que se encuentra en la posici�n p */
    public E removeP(int p) throws IndexOutOfBoundsException {
        if (p < 0 || p >= indice) { // Verifica si la posición está dentro del rango válido
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        E elementoRemovido = lista[p]; // Guarda el elemento que será removido

        // Desplaza los elementos hacia la izquierda para llenar el espacio dejado por
        // el elemento removido
        for (int i = p; i < indice - 1; i++) {
            lista[i] = lista[i + 1];
        }

        lista[indice - 1] = null; // Borra la referencia al último elemento
        indice--; // Decrementa el índice
        return elementoRemovido; // Retorna el elemento removido
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < indice; i++)
            s += lista[i] + "\n";
        return s;

    }
}