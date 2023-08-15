import java.util.*;
import java.io.*;

public class Main {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            result.append(binarySearch(num)).append('\n');
        }

        System.out.println(result);
        reader.close();
    }

    private static int binarySearch(int num) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (num > arr[mid]) {
                lo = mid + 1;
            } else if (num < arr[mid]) {
                hi = mid - 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}