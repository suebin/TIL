import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = reader.readLine();
            if (word.length() >= m) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        List<String> words = new ArrayList<>(wordMap.keySet());

        words.sort((o1, o2) -> {
            if ((int) wordMap.get(o1) != wordMap.get(o2)) {
                return Integer.compare(wordMap.get(o2), wordMap.get(o1));
            }

            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }

            return o1.compareTo(o2);
        });

        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            ans.append(word).append('\n');
        }

        System.out.print(ans);
    }
}