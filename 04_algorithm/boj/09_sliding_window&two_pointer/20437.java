import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            String w = reader.readLine();
            int k = Integer.parseInt(reader.readLine());

            if (k == 1) {
                result.append(1).append(' ').append(1).append('\n');
                continue;
            }

            int[] alphabet = new int[26];
            for (int j = 0; j < w.length(); j++) {
                alphabet[w.charAt(j) - 'a']++;
            }

            int minLength = 10001;
            int maxLength = 0;

            for (int j = 0; j < w.length(); j++) {
                if (alphabet[w.charAt(j) - 'a'] < k) continue;

                int cnt = 1;
                for (int l = j + 1; l < w.length(); l++) {
                    if (w.charAt(j) == w.charAt(l)) cnt++;
                    if (cnt == k) {
                        int length = l - j + 1;
                        if (length < minLength) minLength = length;
                        if (length > maxLength) maxLength = length;
                        break;
                    }
                }
            }


            if (maxLength == 0) result.append(-1).append('\n');
            else result.append(minLength).append(' ').append(maxLength).append('\n');
        }

        System.out.print(result);
        reader.close();
    }
}