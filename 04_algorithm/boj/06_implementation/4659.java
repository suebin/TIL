import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        while (true) {
            String s = reader.readLine();
            if (s.equals("end")) break;
            ans.append(evaluate(s));
        }

        System.out.print(ans);
    }

    private static String evaluate(String s) {
        boolean hasVowel = false;
        boolean isAcceptable = true;
        int cnt = 0;
        char prev = '.';

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if (isVowel(now) != isVowel(prev)) {
                hasVowel = true;
                cnt = 1;
            } else {
                cnt++;
            }

            if (cnt == 3 || isSame(prev, now)) {
                isAcceptable = false;
                break;
            }

            prev = now;
        }

        return getResult(s, isAcceptable, hasVowel);
    }

    private static String getResult(String s, boolean isAcceptable, boolean hasConsonant) {
        if (isAcceptable && hasConsonant) {
            return "<" + s + "> is acceptable." + "\n";
        }
        return "<" + s + "> is not acceptable." + "\n";
    }

    private static boolean isSame(char c1, char c2) {
        return c1 == c2 && c1 != 'e' && c1 != 'o';
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}