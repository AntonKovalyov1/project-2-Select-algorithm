package programming_project_2;
public class MedianOfMedians {

    private static int compCount = 0;
    
    public MedianOfMedians() {

    }
    
    /**
     * list is the actual elements list, while the sublist contains indices from
     * the list, this way once the subList is sorted (using the actual elements
     * from the list) the method returns the index in the list of the median
     * from the subList.
     */
    public static int findMedianIndex(int[] list, int[] subList) {
        insertionSort(list, subList);
        return subList[(subList.length - 1) / 2];
    }
    
    private static void insertionSort(int[] list, int[] subList) {
        int j;
        for (int i = 0 + 1; i < subList.length; i++) {
            int currentElement = subList[i];
            compCount++;
            for (j = i - 1; j >= 0 && list[subList[j]] > list[currentElement]; 
                    j--) {
                subList[j + 1] = subList[j];
                if (j != 0)
                    compCount++;
            }
            subList[j + 1] = currentElement;
        }
    }
    
    public static int findMedianOfMediansIndex(int[] list, int groupsOf) {
        int[] indexList = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            indexList[i] = i;
        }
        return findMedianOfMediansIndex(list, indexList, groupsOf);
    }
    
    private static int findMedianOfMediansIndex(int[] list, int[] indexList, int
            groupsOf) {
        double n = indexList.length;
        if (n == 1)
            return indexList[0];
        int[] mediansList = new int[(int)Math.ceil(n / groupsOf)];
        int j = 0;
        int numberOfGroups = (int)(n / groupsOf);
        for (int i = 0; i < numberOfGroups; i++) {
            int[] subList = new int[groupsOf];
            System.arraycopy(indexList, j, subList, 0, groupsOf);
            mediansList[i] = findMedianIndex(list, subList);
            j += groupsOf;
        }
        int remainder = (int)(n - j);
        if (remainder != 0) {
           int[] remainderList = new int[remainder];
           System.arraycopy(indexList, j, remainderList, 0, remainder);
           mediansList[numberOfGroups] = findMedianIndex(list, remainderList);
        }
        return findMedianOfMediansIndex(list, mediansList, groupsOf);    
    }

    public static int getCompCount() {
        int temp = compCount;
        compCount = 0;
        return temp;
    }
}
