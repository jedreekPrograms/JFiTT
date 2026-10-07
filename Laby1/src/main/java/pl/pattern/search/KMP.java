package pl.pattern.search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class KMP {
    public static void main (String[] args) {

        if (args.length != 2) {
            System.out.println("Użycie: java FA <wzorzec> <nazwa pliku>");
            return;
        }

        String pattern = args[0];
        String fileName = args[1];

        int[] LPS = buildLPS(pattern);

        try {
            String text = Files.readString(Path.of(fileName));
            search(pattern, text, LPS);
        } catch(IOException e) {
            System.out.println("Nie udało się odczytać pliku");
        }
    }

    public static void search(String pattern, String text, int[] LPS) {

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {

                i++;
                j++;

                if (j == pattern.length()) {
                    System.out.println("Znaleziono wzorzec na pozycji: " + (i - pattern.length()));
                    j = LPS[j - 1];
                }
            } else if (j > 0) {
                j = LPS[j - 1];
            } else {
                i++;
            }
        }
    }

    private static int[] buildLPS(String pattern) {
        int[] LPS = new int[pattern.length()];

        int len = 0;
        for (int i = 1; i < pattern.length(); i++) {

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                LPS[i] = len;
            } else {
                if (len > 0) {
                    while(len > 0) {
                        len = LPS[len - 1];
                        if (pattern.charAt(i) == pattern.charAt(len)) {
                            len++;
                            LPS[i] = len;
                            break;
                        }
                    }
                }
            }
        }

        return LPS;
    }

}
