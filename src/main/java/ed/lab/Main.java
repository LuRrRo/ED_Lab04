package ed.lab;

public class Main {
    private static final ArrayGenerator<String> sortedArrayGenerator = (n) -> {
        String[] lista = new String[n];
        for (int i = 0; i < n; i++) {
            lista[i] = "str" + i;
        }
        return lista;
    };


    private static final ArrayGenerator<String> invertedArrayGenerator = ( n) -> {
        String[] lista = new String[n];
        for (int i = 0; i < n; i++) {
            lista[i] = "str" + (n-1);
        }
        return lista;
    };

    private static final ArrayGenerator<String> randomArrayGenerator = ( n) -> {
        String[] lista = new String[n];
        for (int i = 0; i < n; i++) {
            lista[i] = "str" + (Math.random()*n);
        }
        return lista;
    };

    private static final QuickSort<String> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort; // Reemplácelo por una referencia a un método

    private static final QuickSort<String> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort; // Reemplácelo por una referencia a un método

    private static final QuickSort<String> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort; // Reemplácelo por una referencia a un método

    public static QuickSort<String> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }

    public static QuickSort<String> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<String> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static ArrayGenerator<String> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<String> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<String> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static void main(String[] args) {
        final SortingTester<String> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        /* Pruebas unitarias de las implementaciones de ArrayGenerator
        Integer[] l1 = invertedArrayGenerator.generate(6);
        Integer[] l2 = randomArrayGenerator.generate(6);
        Integer[] l3 = sortedArrayGenerator.generate(6);
        for (int x:l1){
            System.out.println(x);
        }
        for (int x:l2){
            System.out.println(x);
        }
        for (int x:l3){
            System.out.println(x);
        }*/
       tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");
    }
}