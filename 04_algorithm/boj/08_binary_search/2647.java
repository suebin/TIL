import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        findValueByBinarySearch(arr);
    }

    private static void findValueByBinarySearch(long[] arr) {
        long minSum = Long.MAX_VALUE;
        int leftIdx = 0;
        int rightIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                long sum = arr[i] + arr[mid];

                if (minSum > Math.abs(sum)) {
                    minSum = Math.abs(sum);
                    leftIdx = i;
                    rightIdx = mid;
                }

                if (sum > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        System.out.println(arr[leftIdx] + " " + arr[rightIdx]);
    }
}

/**
 * Two Pointer 풀이.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        findValueByTwoPointer(arr);
    }

    private static void findValueByTwoPointer(long[] arr) {
        int left = 0;
        int right = arr.length - 1;
        long minSum = Long.MAX_VALUE;
        int leftIdx = 0;
        int rightIdx = 0;

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (minSum > Math.abs(sum)) {
                minSum = Math.abs(sum);
                leftIdx = left;
                rightIdx = right;
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.print(arr[leftIdx] + " " + arr[rightIdx]);
    }
}