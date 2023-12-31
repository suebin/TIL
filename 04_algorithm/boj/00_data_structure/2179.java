import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            if (!list.contains(s)) {
                list.add(s);
            }
        }

        String[] ans = new String[2];
        int maxCnt = 0;

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                String t = list.get(j);

                int cnt = 0;
                int len = Math.min(s.length(), t.length());
                for (int k = 0; k < len; k++) {
                    if (s.charAt(k) != t.charAt(k)) break;
                    cnt++;
                }

                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    ans[0] = s;
                    ans[1] = t;
                }
            }
        }

        System.out.print(ans[0] + "\n" + ans[1]);
    }
}