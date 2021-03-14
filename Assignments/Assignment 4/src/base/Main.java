package base;

import java.util.Arrays;

public class Main {

    static int summation(int[] intList){
        int sum = intList[0];
        for(int i = 1; i < intList.length; i++) {
            sum += intList[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4};
        System.out.println(Arrays.toString(array));
        System.out.print(summation(array));
    }
}
