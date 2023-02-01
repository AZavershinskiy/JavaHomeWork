package Sem3;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    // Пусть дан произвольный список целых чисел
    public static void main(String[] args) {
        List<Integer> list1 = List.of(23, 9, 12, 5, 15, 4, 7, 8);
        System.out.println("ИСХОДНЫЙ список:" + list1);
        System.out.println("Список без четных чисел: " + removeEvenValue(list1));
        System.out.println("Минимальное значение исходного списка: " + getMin(list1));
        System.out.println("Максимальное значение исходного списка: " + getMax(list1));
        System.out.println("Cреднее значение исходного списка с округлением: " + getAverage(list1));
    }

    // Нужно удалить из него четные числа
    public static List<Integer> removeEvenValue(List<Integer> list) {
        List<Integer> list2 = new ArrayList<>();
        for (int i : list) {
            if (i % 2 != 0)
                list2.add(i);
        }
        return list2;
    }

    // Найти минимальное значение
    public static Integer getMin(List<Integer> list) {
        int min = list.get(0);
        for (Integer i : list) {
            if (i < min)
                min = i;
        }
        return min;
    }

    // Найти максимальное значение
    public static Integer getMax(List<Integer> list) {
        int max = list.get(0);
        for (Integer i : list) {
            if (i > max)
                max = i;
        }
        return max;
    }

    // Найти среднее значение
    public static Integer getAverage(List<Integer> list) {
        int sum = 0;
        for (Integer i : list)
            sum += i;
        int mid = sum / list.size();
        return mid;
    }
}