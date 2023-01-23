/*
Task1 
Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
Для генерации случайного числа используйте метод Math.random(), 
который возвращает значение в промежутке [0, 300]
*/

package Sem1;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 301);
        System.out.println("Получившийся массив: " + Arrays.toString(arr));
        System.out.println("Максимальное значение: " + maxValue(arr));
        System.out.println("Минимальное значение: " + minValue(arr));
        System.out.println("Среднее значение: " + midValue(arr));
    }

    public static int maxValue(int[] array) {
        int maxValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue)
                maxValue = array[i];
        }
        return maxValue;
    }

    public static int minValue(int[] array) {
        int minValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValue)
                minValue = array[i];
        }
        return minValue;
    }

    public static int midValue(int[] array) {
        int sumValue = 0;
        for (int i = 0; i < array.length; i++) {
            sumValue += array[i];
        }
        int midValue = sumValue / array.length;
        return midValue;
    }
}
