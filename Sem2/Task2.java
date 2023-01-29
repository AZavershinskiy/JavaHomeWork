// Не обязательная!
/*
Напишите программу, которая:
1) по указанной строке URL скачивает файл и возвращает строковое содержимое файла;
2) изменяет строковое содержимое файла подставляя по маске "%s" ваше имя;
3) сохраняет файл локально;
4) читает сохраненный файл и выводит содержимое в логгер;
5) удаляет сохраненный файл.

Адрес: https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt
*/

package Sem2;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    public static void main(String[] args) throws Exception {
        String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
        String localFileName = "Sem2/example.txt";

        String strDownloaded = download(fileUrl, localFileName);
        String mask = "%s";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.next();
        scanner.close();

        String str2 = change(name, strDownloaded, mask);

        saveOnLocal(localFileName, str2);

        read(localFileName);

        removeFromLocale(localFileName);
    }

    public static String download(String url, String localFilename) throws Exception {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(localFilename)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            StringBuilder sb = new StringBuilder();
            try (FileReader fr = new FileReader(localFilename)) {
                while (fr.ready()) {
                    char ch = (char) fr.read();
                    sb.append(ch);
                }
                return sb.toString();
            }
        }
    }

    public static String change(String name, String fileContent, String mask) {
        String newstr = fileContent.replace(mask, name);
        return newstr;
    }

    public static void saveOnLocal(String fileName, String fileContent) throws Exception {
        try (FileWriter fw = new FileWriter(fileName, false)) {
            fw.write(fileContent);
            fw.flush();
        }
    }

    public static void read(String localFilename) throws Exception {
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(localFilename)) {
            while (fr.ready()) {
                char ch = (char) fr.read();
                sb.append(ch);
            }
            Logger logger = Logger.getLogger(Task2.class.getName());
            FileHandler fh = new FileHandler("Sem2/logs2.log", true);
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.info(sb.toString());
        }
    }

    public static void removeFromLocale(String fileName) throws Exception {
        Path path = Paths.get(fileName);
        try {
            Files.deleteIfExists(path);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}