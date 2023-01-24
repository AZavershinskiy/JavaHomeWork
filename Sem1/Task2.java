/*
Task2 
Реализуйте алгоритм сортировки пузырьком для сортировки массива
*/

package Sem1;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] arr = {35, 7, 1, 88, 11, 90, 12, -4, 3};
        System.out.println("Массив ДО сортировки: " + Arrays.toString(arr));
        System.out.println("Массив ПОСЛЕ сортировки: " + Arrays.toString(bubbleSort(arr)));
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
