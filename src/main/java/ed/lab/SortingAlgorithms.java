package ed.lab;
import java.util.Random;

public class SortingAlgorithms {

    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSortHigh(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortHigh(T[] array, int inicio, int fin) {
        if (inicio < fin) {
            int pi = partirFin(array, inicio, fin);
            quickSortHigh(array, inicio, pi - 1);
            quickSortHigh(array, pi + 1, fin);
        }
    }

    private static <T extends Comparable<T>> int partirFin(T[] array, int inicio, int fin) {
        T pivote = array[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (array[j].compareTo(pivote) <= 0) {
                i++;
                Cambio(array, i, j);
            }
        }
        Cambio(array, i + 1, fin);
        return i + 1;
    }


    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSortLow(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortLow(T[] array, int inicio, int fin) {
        if (inicio < fin) {
            int pi = PartirInicio(array, inicio, fin);
            quickSortLow(array, inicio, pi - 1);
            quickSortLow(array, pi + 1, fin);
        }
    }

    private static <T extends Comparable<T>> int PartirInicio(T[] array, int inicio, int fin) {
        T pivote = array[inicio];
        int i = inicio + 1;

        for (int j = inicio + 1; j <= fin; j++) {
            if (array[j].compareTo(pivote) < 0) {
                Cambio(array, i, j);
                i++;
            }
        }
        Cambio(array, inicio, i - 1);
        return i - 1;
    }


    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSortRandom(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortRandom(T[] array, int inicio, int fin) {
        if (inicio < fin) {
            int pi = partirRandom(array, inicio, fin);
            quickSortRandom(array, inicio, pi - 1);
            quickSortRandom(array, pi + 1, fin);
        }
    }

    private static <T extends Comparable<T>> int partirRandom(T[] array, int inicio, int fin) {
        int indiceRand = new Random().nextInt(fin - inicio + 1) + inicio;
        Cambio(array, indiceRand, fin); // mover pivote al final
        return partirFin(array, inicio, fin);
    }

    private static <T> void Cambio(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
