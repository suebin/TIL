import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];
        int lisLen = 1;

        for (int i = 1; i < n; i++) {
            int lisLastNum = lis[lisLen - 1];

            if (lisLastNum < arr[i]) {
                lis[lisLen++] = arr[i];
            } else if (lisLastNum > arr[i]) {
                lis[lowBound(lis, lisLen, arr[i])] = arr[i];
            }
        }

        System.out.print(lisLen);
    }

    private static int lowBound(int[] lis, int lisLen, int num) {
        int lo = 0;
        int hi = lisLen;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (num <= lis[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}