package javabasics;

public class MergeSort {

    public static void conquer(int[] arr, int si, int mid, int ei){
        int[] merger = new int[ei - si +1];

        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        // O(n)
        while(idx1 <= mid && idx2 <= ei){
            if(arr[idx1] <= arr[idx2]){
                merger[x++] = arr[idx1++];
            }else{
                merger[x++] = arr[idx2++];
            }
        }

        while(idx1 <= mid){
            merger[x++] = arr[idx1++];
        }

        while (idx2 <= ei){
            merger[x++] = arr[idx2++];
        }

        for (int i = 0, j = si; i < merger.length; i++, j++) {
            arr[j] = merger[i];
        }

    }

    public static void divide(int[] arr, int si, int ei){

        if(si >= ei){
            return;
        }

        // O(log n)
        int mid = si + (ei - si)/2;
        divide(arr, si, mid);
        divide(arr, mid+1, ei);
        conquer(arr, si, mid, ei);
    }

    public static void main(String[] args) {

        int[] arr = {6,3,9,5,2,8};
        int n = arr.length;

        divide(arr, 0 , n-1);

        // O (n log n)
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // enhanced for loop
        for(int j : arr){
            System.out.print(j + " ");
        }
        System.out.println();

    }
}
