import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(reader.readLine());
        }

        int[] check = new int[d + 1];
        int start = 0;
        int end = 0;
        int cnt = 0;
        int maxCnt = 0;
        int couponCnt = 0;

        while (start < n) {
            while (end < start + k) {
                if (check[sushi[end % n]] == 0) cnt++;
                if (sushi[end % n] == c) couponCnt++;
                check[sushi[end % n]]++;
                end++;
            }

            maxCnt = Math.max(maxCnt, couponCnt == 0 ? cnt + 1 : cnt);

            if (check[sushi[start]] == 1) cnt--;
            if (sushi[start] == c) couponCnt--;
            check[sushi[start++]]--;
        }

        System.out.print(maxCnt);
    }
}