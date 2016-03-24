package programming_project_2;

import java.util.concurrent.TimeUnit;

public class Benchmarking {
    

    public Benchmarking() {

    }
    
    public void testSelection(int listSize, int k) {
        int[] results;
        System.out.println("Running times in milliseconds and number of "
                + "comparisons for 5 different select algorithms, where the "
                + "size of the list is " + listSize + " and k is " + k + ":");
        results = testSorting(listSize, k);
        System.out.println("Selection through Sorting: " + results[0] + "ms "
                + "and " + results[1] + " comparisons.");
        results = testMinHeap(listSize, k);
        System.out.println("Selection through MinHeap: " + results[0] + "ms "
                + "and " + results[1] + " comparisons.");
        results = testMaxHeap(listSize, k);
        System.out.println("Selection through MaxHeap: " + results[0] + "ms "
                + "and " + results[1] + " comparisons.");
        results = testRandomizedSelect(listSize, k);
        System.out.println("Selection through Randomized Select: " + results[0]
                + "ms and " + results[1] + " comparisons.");
        results = testGroupsOf5(listSize, k);
        System.out.println("Selection through Groups of 5: " + results[0] + "ms"
                + " and " + results[1] + " comparisons.\n");
    }
    
    public int[] testSorting(int listSize, int k) {
        int[][] results = new int[2][5];
        int[] finalResults = new int[2];
        long then;
        for (int i = 0; i < 5; i++) {
            then = System.nanoTime();
            Selection.throughSorting(randomListGenerator(listSize), k);
            results[0][i] = (int)TimeUnit.NANOSECONDS.toMillis(System.nanoTime()
                    - then);
            results[1][i] = Selection.getCompCount();
        }
        finalResults[0] = max(results[0]);
        finalResults[1] = max(results[1]);
        return finalResults;
    }
    
    public int[] testMinHeap(int listSize, int k) {
        int[][] results = new int[2][5];
        int[] finalResults = new int[2];
        long then;
        for (int i = 0; i < 5; i++) {
            then = System.nanoTime();
            Selection.throughMinHeap(randomListGenerator(listSize), k);
            results[0][i] = (int)TimeUnit.NANOSECONDS.toMillis(System.nanoTime()
                    - then);
            results[1][i] = Selection.getCompCount();
        }
        finalResults[0] = max(results[0]);
        finalResults[1] = max(results[1]);
        return finalResults;
    }
    
    public int[] testMaxHeap(int listSize, int k) {
        int[][] results = new int[2][5];
        int[] finalResults = new int[2];
        long then;
        for (int i = 0; i < 5; i++) {
            then = System.nanoTime();
            Selection.throughMaxHeap(randomListGenerator(listSize), k);
            results[0][i] = (int)TimeUnit.NANOSECONDS.toMillis(System.nanoTime()
                    - then);
            results[1][i] = Selection.getCompCount();
        }
        finalResults[0] = max(results[0]);
        finalResults[1] = max(results[1]);
        return finalResults;
    }
    
    public int[] testRandomizedSelect(int listSize, int k) {
        int[][] results = new int[2][5];
        int[] finalResults = new int[2];
        long then;
        for (int i = 0; i < 5; i++) {
            then = System.nanoTime();
            Selection.throughRandomizedSelect(randomListGenerator(listSize), k);
            results[0][i] = (int)TimeUnit.NANOSECONDS.toMillis(System.nanoTime()
                    - then);
            results[1][i] = Selection.getCompCount();
        }
        finalResults[0] = average(results[0]);
        finalResults[1] = average(results[1]);
        return finalResults;
    }
    
    public int[] testGroupsOf5(int listSize, int k) {
        int[][] results = new int[2][5];
        int[] finalResults = new int[2];
        long then;
        for (int i = 0; i < 5; i++) {
            then = System.nanoTime();
            Selection.throughGroupsOf5(randomListGenerator(listSize), k);
            results[0][i] = (int)TimeUnit.NANOSECONDS.toMillis(System.nanoTime()
                    - then);
            results[1][i] = Selection.getCompCount();
        }
        finalResults[0] = max(results[0]);
        finalResults[1] = max(results[1]);
        return finalResults;
    }
    
    // Returns a list with random values from 0 to 99
    public int[] randomListGenerator(int size) {
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int)(Math.random() * 100);
        }
        return list;
    }
    
    public int max(int[] list) {
        int max = list[0];
        for (int i = 0; i < list.length; i++) {
            if (max < list[i])
                max = list[i];
        }
        return max;
    }
    
    public int average(int[] list) {
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return sum / list.length;
    }
}
