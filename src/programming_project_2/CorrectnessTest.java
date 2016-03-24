package programming_project_2;
public class CorrectnessTest {
    
    private final static int[] testArray = {1,2,3,4,5,6,7,8,9,10,7,3,8};
    private final static int n = testArray.length;
    
    public static void test() {
        System.out.println("Test the 5 algorithms for an array of 13 elements "
                + "from 1 to 10, with k going from 1 to 13, the output should "
                + "be 1 2 3 3 4 5 6 7 7 8 8 9 10: ");
        
        System.out.println("Selection through sorting: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(Selection.throughSorting(testArray, i) + " ");
            shuffle();
        }
        
        System.out.println("\nSelection through MinHeap: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(Selection.throughMinHeap(testArray, i) + " ");
            shuffle();
        }
        
        System.out.println("\nSelection through MaxHeap: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(Selection.throughMaxHeap(testArray, i) + " ");
            shuffle();
        }
        
        System.out.println("\nSelection through Randomized Select: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(Selection.throughRandomizedSelect(testArray, i) + 
                    " ");
            shuffle();
        }
        
        System.out.println("\nSelection through Groups of 5: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(Selection.throughGroupsOf5(testArray, i) + " ");
            shuffle();
        }
        System.out.println("");
    }
    
    public static void shuffle() {
        for (int i = 0; i < n; i++) {
            swap(i, (int)(Math.random() * (n - i) + i));
        }
    }
    
    public static void swap(int i, int j) {
        int temp = testArray[i];
        testArray[i] = testArray[j];
        testArray[j] = temp;
    }
}
