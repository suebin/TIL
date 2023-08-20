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

        int lisLength = 1;
        lis[0] = arr[0];

        for (int num : arr) {
            int lastLisNum = lis[lisLength - 1];

            if (num > lastLisNum) {
                lis[lisLength] = num;
                lisLength++;
            } else if (num < lastLisNum) {
                lis[lowBound(lis, lisLength, num)] = num;
            }
        }

        System.out.print(lisLength);
        reader.close();
    }

    private static int lowBound(int[] arr, int length, int num) {
        int lo = 0;
        int hi = length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (num <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}