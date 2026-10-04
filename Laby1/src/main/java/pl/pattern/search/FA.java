package pl.pattern.search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FA {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Użycie: java FA <wzorzec> <nazwa pliku>");
            return;
        }

        String pattern = args[0];
        String fileName = args[1];

        try {
            String text = Files.readString(Path.of(fileName));

            int[][] transition = buildTransitionTable(pattern);

        } catch (IOException e) {
            System.out.println("Nie udało się odczytać pliku");
        }
    }

    private static int[][] buildTransitionTable(String pattern) {
        int m = pattern.length();

        int[][] transition = new int[m + 1][128];
        return transition;
    }
}
