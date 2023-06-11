package training.sorting;

import java.util.Arrays;

public class ArraySorting {

    public static int[] getSortedArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int bufferValue = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = bufferValue;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {9,0,1,10,4,7,2,3,5,6,8,7};
        System.out.println(Arrays.toString(getSortedArray(array)));
    }
}