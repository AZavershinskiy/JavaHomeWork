import java.io.IOException;
import java.util.logging.*;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(Test.class.getName());
        FileHandler fh = new FileHandler("test_logs.log", true);
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        logger.log(Level.WARNING, "Error 1");
        logger.info("Error 2\n");

        /* 
        List<String> list = new ArrayList<>(Arrays.asList("a", "2a", "b", "3", "c", "4"));
        printResultOfCheck(list);
    }

    public static void printResultOfCheck(List<String> list) {
        for (String item : list) {
            if (isDigit(item)) {
                System.out.println(item + " is digit.");
            } else
                System.out.println(item + " is String.");
        }
    }

    public static boolean isDigit(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
         */
    }

}