import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int ans = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] a = new int[m];
        int maxA = 0;
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(reader.readLine());
            maxA += a[i];
        }

        int[] b = new int[n];
        int maxB = 0;
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(reader.readLine());
            maxB += b[i];
        }

        int[] aSums = getSums(a, maxA, size);
        int[] bSums = getSums(b, maxB, size);

        int bSize = size;
        for (int aSize = 0; aSize <= size; aSize++) {
            ans += (aSums[aSize] * bSums[bSize--]);
        }

        System.out.print(ans);
    }

    private static int[] getSums(int[] arr, int maxCnt, int size) {
        int len = arr.length;
        int[] sums = new int[Math.max(maxCnt, size) + 1];
        sums[0] = 1;
        sums[maxCnt] = 1;

        for (int start = 0; start < len; start++) {
            int end = start;
            int sum = 0;
            int cnt = 1;

            while (sum <= size && cnt++ < len) {
                sum += arr[end++];
                sums[sum]++;
                if (end == len) end = 0;
            }
        }

        return sums;
    }
}