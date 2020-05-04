package main.java.janhen.swordoffer.a_good.problem51;

public class Solution {
    private long cnt = 0;

    public int InversePairs(int [] array) {
        mergeSort(array, 0, array.length - 1);
        return (int) (cnt % 1000000007);
    }

    public void mergeSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int mid = lo + (hi-lo)/2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid+1, hi);
        merge(arr, lo, mid, hi);
    }

    public void merge(int[] arr, int lo, int mid, int hi) {
        int[] aux = new int[hi - lo + 1];
        int i = lo, j = mid + 1;
        for (int k = 0; k < aux.length; k ++) {
            if (i > mid) {
                aux[k] = arr[j ++];
            } else if (j > hi) {
                aux[k] = arr[i ++];
            } else if (arr[i] <= arr[j]) {
                aux[k] = arr[i ++];
            } else {
                this.cnt += mid - i + 1;
                aux[k] = arr[j ++];
            }
        }
        for (int k = 0; k < aux.length; k ++) {
            arr[k + lo] = aux[k];
        }
    }
}