import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        String t = reader.readLine();

        System.out.println(dfs(s, t));
        reader.close();
    }

    private static int dfs(String s, String t) {
        if (s.length() == t.length()) {
            return s.contentEquals(t) ? 1 : 0;
        }

        int result = 0;

        if (t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(t);
            sb.deleteCharAt(0);
            sb.reverse();
            result += dfs(s, sb.toString());
        }

        if (t.charAt(t.length() - 1) == 'A') {
            result += dfs(s, t.substring(0, t.length() - 1));
        }

        return result > 0 ? 1 : 0;
    }
}