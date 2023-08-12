import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        if (n == 1) {
            System.out.println(reader.readLine());
            return;
        }

        Map<String, Integer> bookMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String book = reader.readLine();
            bookMap.put(book, bookMap.getOrDefault(book, 1) + 1);
        }

        int max = 0;
        String bestSeller = "";

        for (String book : bookMap.keySet()) {
            int value = bookMap.get(book);

            if ((max == value && bestSeller.compareTo(book) > 0) || max < value) {
                bestSeller = book;
                max = value;
            }
        }
        System.out.println(bestSeller);
        reader.close();
    }
}