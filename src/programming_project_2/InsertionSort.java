package programming_project_2;

public class InsertionSort {
    
    private static int compCount = 0;

    public static int getCompCount() {
        return compCount;
    }
    
    public static void clearCompCount() {
        compCount = 0;
    }
   
    public static void sort(int[] list) {
        sort(list, 0, list.length - 1);
    }
    
    public static void sort(int[] list, int start, int end) {
        int j;
        for (int i = start + 1; i <= end; i++) {
            int currentElement = list[i];
            compCount++;
            for (j = i - 1; j >= start && list[j] > currentElement; j--) {
                list[j + 1] = list[j];
                if (j != start)
                    compCount++;
            }
            list[j + 1] = currentElement;
        }
    }
}

