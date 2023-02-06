package Sem4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// Дан Deque состоящий из последовательности цифр.
// Необходимо проверить, что последовательность цифр является палиндромом

public class Task1 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                deque2 = new ArrayDeque<>(Arrays.asList(1, 2, 3, 2, 1));
        System.out.println(checkOn(deque));
        System.out.println(checkOn(deque2));
    }

    public static boolean checkOn(Deque<Integer> deque) {
        if (deque.size() == 1)
            return false;
        while (deque.size() > 1)
            if (deque.pollFirst() != deque.pollLast())
                return false;
        return true;
    }
}