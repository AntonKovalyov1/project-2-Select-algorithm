package programming_project_2;
public class Selection {
    
    private static final FixedSizeHeap heap = new FixedSizeHeap();
    private static int compCount = 0;
    
    public static int throughMaxHeap(int[] list, int k) {
        int[] kList = new int[k];
        System.arraycopy(list, 0, kList, 0, k);
        getHeap().buildMaxHeap(kList);
        compCount += heap.getCompCount();
        for (int i = k; i < list.length; i++) {
            compCount++;
            if (list[i] < getHeap().getMaximum()) {
                getHeap().swapMax(list[i]);
                compCount += heap.getCompCount();
            }
        }
        return getHeap().getMaximum();
    }
    
    public static int throughMinHeap(int[] list, int k) {
        int heapSize = list.length - k + 1;
        int[] kList = new int[heapSize];
        System.arraycopy(list, 0, kList, 0, heapSize);
        getHeap().buildMinHeap(kList);
        compCount += heap.getCompCount();
        for (int i = heapSize; i < list.length; i++) {
            compCount++;
            if (list[i] > getHeap().getMinimum()) {
                getHeap().swapMin(list[i]);
                compCount += heap.getCompCount();
            }
        }
        return getHeap().getMinimum();
    }
    
    public static int throughSorting(int[] list, int k) {
        int i = getHeap().heapSort(list)[k];
        compCount += heap.getCompCount();
        return i;
    }
    
    public static int throughRandomizedSelect(int[] list, int k) {
        return throughRandomizedSelect(list, 0, list.length - 1, k);
    }
    
    public static int throughRandomizedSelect(int[] list, int start, int end, 
            int k) {
        int q = QuickSort.randomizedPartition(list, start, end);
        compCount += QuickSort.getCompCount();
        int i = q - start + 1;
        if (k == i)
            return list[q];
        else if (k < i)
            return throughRandomizedSelect(list, start, q - 1, k);
        else return throughRandomizedSelect(list, q + 1, end, k - i);
    }
    
    public static int throughGroupsOf5(int[] list, int k) {
        int pivot = MedianOfMedians.findMedianOfMediansIndex(list, 5);
        compCount += MedianOfMedians.getCompCount();
        int q = QuickSort.setPivotPartition(list, pivot);
        compCount += QuickSort.getCompCount();
        int i = q + 1;
        if (k == i)
            return list[q];
        else if (k < i) {
            int[] leftSubList = new int[q];
            System.arraycopy(list, 0, leftSubList, 0, q);
            return throughGroupsOf5(leftSubList, k);
        }
        else {
            int[] rightSubList = new int[list.length - i];
            System.arraycopy(list, i , rightSubList, 0, list.length - i);
            return throughGroupsOf5(rightSubList, k - i);
        }
    }

    public static FixedSizeHeap getHeap() {
        return heap;
    }
    
    public static int getCompCount() {
        int temp = compCount;
        compCount = 0;
        return temp;
    }
}
