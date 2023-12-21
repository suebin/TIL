import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = twoPointer(arr, n);
        System.out.print(ans);
    }

    private static long twoPointer(int[] arr, int n) {
        int[] check = new int[100001];
        int start = 0;
        int end = 0;
        long cnt = 0;

        while (start < n) {
            while (end < n && check[arr[end]] == 0) {
                check[arr[end]]++;
                end++;
                if (end == n) break;
            }

            cnt += end - start;
            check[arr[start]]--;
            start++;
        }

        return cnt;
    }
}