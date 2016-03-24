package programming_project_2;

public class QuickSort {
    
    private static int compCount = 0;
    
    public static void randomizedQuickSort(int[] list) {
        randomizedQuickSort(list, 0, list.length - 1);
    }
    
    public static void randomizedQuickSort(int list[], int start, int end) {
        int q = randomizedPartition(list, start, end);
        if (start < q - 1)
            randomizedQuickSort(list, start, q - 1);
        if (end > q + 1)
            randomizedQuickSort(list, q + 1, end);
    }
    
    public static int randomizedPartition(int[] list, int start, int end) {
        int i = randomNumber(start, end);
        swap(list, i, end);
        return partition(list, start, end);
    }
    
    public static int setPivotPartition(int[] list, int pivot) {
        return setPivotPartition(list, 0, list.length - 1, pivot);
    }
    
    public static int setPivotPartition(int list[], int start, int end, 
            int pivot) {
        swap(list, pivot, end);
        return partition(list, start, end);
    }

    public static int partition(int list[], int left, int right) {
        int i = left - 1; 
        int j = left;
        int p = right;
        while (p != j) {
            if (list[p] > list[j]) {
                compCount++;
                swap(list, i + 1, j);
                i++;
            }
            j++;
        }
        swap(list, i + 1, p);
        return i + 1;
    }
    
    private static void swap(int[] list, int i, int j) { 
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    
    private static int randomNumber(int start, int end) {
        return (int)(Math.random() * ((end - start) + 1)) + start;
    }

    /**
     * @return the compCount
     */
    public static int getCompCount() {
        int temp = compCount;
        compCount = 0;
        return temp;
    }
}
