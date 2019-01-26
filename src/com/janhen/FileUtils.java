package com.janhen;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileUtils {

    public static List<String> readFile(String filename) {
        if (filename == null) {
            System.out.println("filename is null");
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        File file = new File(filename);
        Scanner scanner = null;

        if (file.exists()) {
            try {
                BufferedInputStream bufferIn = new BufferedInputStream(new FileInputStream(file));
                scanner = new Scanner(bufferIn, "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } catch (IOException e) {
                System.out.println("Cannot open : " + filename);
                return list;
            }
        } else {
            System.out.println("Cannot open : " + filename);
            return list;
        }

        if (scanner.hasNextLine()) {
            // ???
            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); ) {
                char c = contents.charAt(i);
                if (i == contents.length() || !Character.isLetter(c)) {
                    String word = contents.substring(start, i).toLowerCase();
                    list.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else
                    i++;
            }
        }

        return list;
    }

    private static int firstCharacterIndex(String str, int start) {
        for (int i = start; i < str.length(); i ++) {
            if (Character.isLetter(str.charAt(i)))
                return i;
        }
        return str.length();
    }
}
