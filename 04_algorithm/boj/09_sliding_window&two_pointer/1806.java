import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int sum = 0;
        int[] nums = new int[n + 1];

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sum += nums[i];
        }

        if (sum < s) {
            System.out.println(0);
            return;
        }

        int length = twoPointer(nums, s, n);
        System.out.print(length);
    }

    private static int twoPointer(int[] nums, int s, int n) {
        int length = n;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (start <= n && end <= n) {
            if (sum >= s && length > end - start) length = end - start;

            if (sum < s) sum += nums[end++];
            else sum -= nums[start++];
        }

        return length;
    }
}