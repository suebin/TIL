import java.util.*;
import java.io.*;

public class Main {
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        dfs(a, b, 0);

        answer = (answer != 0) ? answer + 1 : -1;
        System.out.print(answer);
        reader.close();
    }

    static void dfs(long a, long b, int cnt) {
        if (a > b) return;

        if (a == b) {
            answer = cnt;
            return;
        }

        dfs(a * 2, b, cnt + 1);
        dfs(a * 10 + 1, b, cnt + 1);
    }
}