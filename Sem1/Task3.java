/*
Task3 
Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы
*/

package Sem1;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Простые числа в промежутке [2, 100]: ");
        for (int i = 2; i < 100; i++) {
            if(isPrime(i))
                System.out.print(i + " ");
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        int temp;
        for (int i = 2; i < number / 2; i++) {
            temp = number % i;
            if (temp == 0)
                return false;
        }
        return true;
    }
}
