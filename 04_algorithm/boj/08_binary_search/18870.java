import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];
        int[] sortedArr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortedArr);

        int[] rankArr = new int[n];
        int rank = 0;
        for (int i = 1; i < n; i++) {
            if (sortedArr[i] == sortedArr[i - 1]) {
                rankArr[i] = sortedArr[i - 1];
            } else {
                rankArr[i] = ++rank;
            }
        }

        StringBuilder result = new StringBuilder();

        for (int num : arr) {
            result.append(rankArr[lowerBound(sortedArr, num)]).append(' ');
        }

        System.out.println(result);
        reader.close();
    }

    private static int lowerBound(int[] arr, int num) {
        int lo = 0;
        int hi = arr.length;

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