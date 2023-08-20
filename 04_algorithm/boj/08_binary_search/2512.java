import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] localBudgets = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            localBudgets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(localBudgets);

        int m = Integer.parseInt(reader.readLine());


        System.out.print(getMaxBudget(localBudgets, m));
        reader.close();
    }

    private static int getMaxBudget(int[] localBudgets, int m) {
        int length = localBudgets.length;
        int min = 0;
        int max = localBudgets[length - 1] + 1;

        while (min < max) {
            int mid = (min + max) / 2;
            int sum = mid * length;

            for (int budget : localBudgets) {
                if (budget < mid) sum -= mid - budget;
                else break;
            }

            if (m < sum) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return max - 1;
    }
}