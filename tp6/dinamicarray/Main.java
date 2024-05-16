package dinamicarray;

public class Main {
    // Método main para probar la clase
    public static void main(String[] args) {
        DynamicArrayList<Integer> list = new DynamicArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        System.out.println("Size before trimToSize(): " + list.size());
        list.trimToSize();
        System.out.println("Size after trimToSize(): " + list.size());
    }
}
