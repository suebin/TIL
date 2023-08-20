import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] liquid = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getValueByBinarySearch(liquid));
        reader.close();
    }

    private static int getValueByBinarySearch(int[] liquid) {
        int value = Integer.MAX_VALUE;
        int startIdx = 0;
        int endIdx = 0;

        for (int i = 0; i < liquid.length; i++) {
            int start = i + 1;
            int end = liquid.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                int sum = liquid[i] + liquid[mid];

                if (value > Math.abs(sum)) {
                    value = Math.abs(sum);
                    startIdx = i;
                    endIdx = mid;
                }

                if (sum > 0) end = mid - 1;
                else start = mid + 1;
            }
        }

        return liquid[startIdx] + liquid[endIdx];
    }
}