package programming_project_2;
public class FixedSizeHeap
{
    private int size;
    int[] heap;
    private int compCount = 0;
 
    public FixedSizeHeap() {

    }

    public int parent(int i) {
        return i / 2;
    }
 
    public int left(int i) {
        return 2 * i;
    }
 
    public int right(int i) {
        return 2 * i + 1;
    }
 
    private void swap(int[] list, int first, int second) {
        int temp;
        temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }
    
    public void maxHeapify(int[] list, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l <= size) {
            compCount++;
            if (list[l] > list[i])
                largest = l;
        }
        if (r <= size) {
            compCount++;
            if (list[r] > list[largest])
                largest = r;
        }
        if (largest != i) {
            swap(list, i, largest);
            maxHeapify(list, largest);
        }
    }
    
    public void buildMaxHeap(int[] list) {
        size = list.length;
        heap = new int[size + 1];
        System.arraycopy(list, 0, heap, 1, size);
        for (int i = size / 2; i > 0; i--) {
            maxHeapify(heap, i);
        }
    }

    public int getMaximum() {
        return heap[1];
    }
    
    public void swapMax(int key) {
        heap[1] = key;
        maxHeapify(heap, 1);
    }
    
    private void extractMax() {
        swap(heap, 1, size);
        size--;
        maxHeapify(heap, 1);
    }
    
    // Returns a list starting at index 1
    public int[] heapSort(int[] list) {
        buildMaxHeap(list);
        while (size != 1) {
            extractMax();
        }
        return heap;
    }
    
    public void minHeapify(int[] list, int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l <= size) {
            compCount++;
            if (list[l] < list[i])
                smallest = l;
        }
        if (r <= size) {
            compCount++;
            if (list[r] < list[smallest])
                smallest = r;
        }
        if (smallest != i) {
            swap(list, i, smallest);
            minHeapify(list, smallest);
        }
    }
    
    public void buildMinHeap(int[] list) {
        size = list.length;
        heap = new int[size + 1];
        System.arraycopy(list, 0, heap, 1, size);
        for (int i = size / 2; i > 0; i--) {
            minHeapify(heap, i);
        }
    }
    
    public int getMinimum() {
        return heap[1];
    }
    
    public void swapMin(int key) {
        heap[1] = key;
        minHeapify(heap, 1);
    }

    public int getCompCount() {
        int temp = compCount;
        compCount = 0;
        return temp;
    }
}
