import java.io.*;
import java.util.*;

public class Main {
    private static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = twoPointer(arr);
        System.out.print(ans);
    }

    private static int twoPointer(int[] arr) {
        int len = 0;
        int maxLen = 0;
        int start = 0;
        int end = 0;
        int[] cnt  = new int[100001];

        while (end < n) {
            if (cnt[arr[end]] < k) {
                cnt[arr[end++]]++;
                len++;
                continue;
            }

            maxLen = Math.max(maxLen, len);
            cnt[arr[start++]]--;
            len--;
        }

        return Math.max(maxLen, len);
    }
}