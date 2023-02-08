package Sem5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
// что 1 человек может иметь несколько телефонов.
// Пусть дан список сотрудников: Иван Иванов (и остальные).
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности. 

public class Task1 {
    public static void main(final String[] args) {
        List<String> contacts = new ArrayList<>(Arrays.asList("Иван Иванов 88001122333",
                "Иван Курицин 88001662333", "Иван Курицин 88001112333", "Иван Незлобин 88001122432",
                "Сергей Потапов 88001112453", "Сергей Потапов 8800163214", "Сергей Курицин 8800142421",
                "Михаил Незлобин 880012343"));
        HashMap<String, List<String>> phonebook = fillPhoneBook(contacts);
        countNames(phonebook);
    }

    public static void countNames(HashMap<String, List<String>> phonebook) {
        HashMap<String, Integer> temp = new HashMap<>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (String key : phonebook.keySet()) {
            String newKey = key.substring(0, key.indexOf(" ")).trim();
            temp.put(newKey, temp.getOrDefault(newKey, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(temp.values());
        Collections.sort(list, Collections.reverseOrder());
        for (int num : list) {
            for (Entry<String, Integer> entry : temp.entrySet()) {
                if (entry.getValue().equals(num) && num > 1)
                    sortedMap.put(entry.getKey(), num);
            }
        }
        for (String key : sortedMap.keySet())
            System.out.println(key + "-" + sortedMap.get(key));
    }

    public static HashMap<String, List<String>> fillPhoneBook(List<String> contacts) {
        HashMap<String, List<String>> phonebook = new HashMap<>();
        for (String i : contacts) {
            String key = i.substring(0, i.lastIndexOf(" ")).trim();
            String value = i.substring(i.lastIndexOf(" "), i.length()).trim();
            List<String> temp = phonebook.getOrDefault(key, new ArrayList<>());
            temp.add(value);
            phonebook.put(key, temp);
        }
        return phonebook;
    }
}

// Иван Иванов 88001122333
// Иван Курицин 88001662333
// Иван Курицин 88001112333
// Иван Незлобин 88001122432
// Сергей Потапов 88001112453
// Сергей Потапов 8800163214
// Сергей Курицин 8800142421
// Михаил Незлобин 880012343

// OutPut:
// Иван-3
// Сергей-2

// Потому как если один сотрудник имеет 2 или более номера, 
// его имя считаем 1 раз