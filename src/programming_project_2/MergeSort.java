/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming_project_2;

/**
 *
 * @author Anton
 */
public class MergeSort {

    public static int[] mergeSortToAnotherList(int[] list) {
        int[] copyList = new int[list.length];
        System.arraycopy(list, 0, copyList, 0, list.length);
        mergeSort(copyList);
        return copyList;
    }
    
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            int n = list.length;
            int[] left = new int[n / 2];
            int[] right = new int[n - left.length];
            System.arraycopy(list, 0, left, 0, left.length);
            System.arraycopy(list, left.length, right, 0, right.length);
            mergeSort(left);
            mergeSort(right);
            merge(left, right, list);
        }
    }
    
    private static void merge(int[] left, int[] right, int[] list) {
        int iLeft = 0;
        int iRight = 0;
        int j = 0;
        while(iLeft < left.length && iRight < right.length) {
            if (left[iLeft] <= right[iRight]) {
                list[j] = left[iLeft];
                iLeft++;
            }
            else {
                list[j] = right[iRight];
                iRight++;
            }
            j++;
        }
        System.arraycopy(left, iLeft, list, j, left.length - iLeft);
        System.arraycopy(right, iRight, list, j, right.length - iRight);
    }
    
    public static int selectionThroughSorting(int[] list, int k) {
        return mergeSortToAnotherList(list)[k - 1];
    }
    
}
