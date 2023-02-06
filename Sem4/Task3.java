package Sem4;

import java.util.ArrayDeque;
import java.util.Deque;

// Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']', определите,
// является ли входная строка логически правильной.
// Входная строка логически правильная, если:
// 1) Открытые скобки должны быть закрыты скобками того же типа.
// 2) Открытые скобки должны быть закрыты в правильном порядке. 
// Каждая закрывающая скобка имеет соответствующую открытую скобку того же типа.
// ()[] = true
// () = true
// {[()]} = true
// ()() = true
// )()( = false

public class Task3 {
    public static void main(String[] args) {
        String str1 = "(){}[]";
        String str2 = "{[()]}";
        String str3 = ")()(";
        String str4 = "{}[(])";

        System.out.println(str1 + " = " + validate(str1));
        System.out.println(str2 + " = " + validate(str2));
        System.out.println(str3 + " = " + validate(str3));
        System.out.println(str4 + " = " + validate(str4));
    }

    public static boolean validate(String str) {
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char elem = str.charAt(i);
            if ("[{(".indexOf(elem) >= 0)
                dq.addFirst(elem);
            else {
                if (dq.peekFirst() == null)
                    return false;
                char stack = dq.pollFirst();
                if (elem == ')' && stack != '(')
                    return false;
                if (elem == '}' && stack != '{')
                    return false;
                if (elem == ']' && stack != '[')
                    return false;
            }
        }
        if (dq.size() != 0)
            return false;
        return true;
    }
}
