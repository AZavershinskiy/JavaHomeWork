// Обязательная!
/*
Напишите программу, которая принимает с консоли число в формате byte и
записывает его в файл ”result.txt”.
Требуется перехватить все возможные ошибки и вывести их в логгер.
    
После написания, попробуйте подать на вход числа 100 и 200 и проследите
разницу в результате
*/

package Sem2;

import java.io.*;
import java.util.Scanner;
import java.util.logging.*;

public class Task1 {
    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите число: ");
            byte num = scanner.nextByte();
            try (FileWriter fw = new FileWriter("Sem2/result.txt", true)) {
                fw.write(num + "\n");
                fw.flush();
                scanner.close();
            }
        } catch (Exception ex) {
            Logger logger = Logger.getLogger(Task1.class.getName());
            FileHandler fh = new FileHandler("Sem2/logs1.log", true);
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.log(Level.WARNING , ex.toString());
        }
    }
}