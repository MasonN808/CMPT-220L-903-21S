package src.base;
import java.util.*;

public class Main {
    public static int[] bubbleSort(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,22,4,5,3,5};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}