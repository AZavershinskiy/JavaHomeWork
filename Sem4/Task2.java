package Sem4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся
// в обратном порядке,
// и каждый из их узлов содержит одну цифру.
// Сложите два числа и верните сумму в виде связанного списка.

public class Task2 {
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5, 4, 7));
        // result [6,6,0,1]
        System.out.println(sumDeque(d1, d2) + " - сумма в виде связанного списка");
    }

    public static Deque<Integer> sumDeque(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> sum = new ArrayDeque<>();
        var d1str = "";
        var d2str = "";
        int size = d1.size();
        for (int i = 0; i < size; i++) {
            d1str += d1.pollLast();
            d2str += d2.pollLast();
        }
        int sumInt = Integer.parseInt(d1str) + Integer.parseInt(d2str);
        String sumString = Integer.toString(sumInt);
        for (int i = sumString.length() - 1; i >= 0; i--) {
            int num = Character.getNumericValue(sumString.charAt(i));
            sum.add(num);
        }
        return sum;
    }
}
