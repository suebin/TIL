import java.io.*;
import java.util.*;

public class Main {
    private static int L, C;
    private static String[] pwd, list;
    private static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer = new StringBuilder();

        pwd = new String[L];
        list = reader.readLine().split(" ");

        Arrays.sort(list);
        findPwd(0, 0);

        System.out.print(answer);
    }

    private static void findPwd(int depth, int idx) {
        if (depth == L) {
            if (check(pwd)) {
                for (String p : pwd) {
                    answer.append(p);
                }
                answer.append("\n");
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            pwd[depth] = list[i];
            findPwd(depth + 1, i + 1);
        }
    }

    private static boolean check(String[] pwd) {
        int v = 0;
        int c = 0;

        for (String s : pwd) {
            if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
                v++;
            } else {
                c++;
            }
        }

        return v >= 1 && c >= 2;
    }
}