import java.io.*;

public class Main {
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String t = reader.readLine();

        check(s, t);
        System.out.print(ans);
    }

    private static void check(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) ans = 1;
            return;
        }

        char lastAlphabet = t.charAt(t.length() - 1);

        t = t.substring(0, t.length() - 1);
        if (lastAlphabet == 'B') t = reverse(t);
        check(s, t);
    }

    private static String reverse(String s) {
        StringBuilder reverseS = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reverseS.append(s.charAt(i));
        }
        return reverseS.toString();
    }
}