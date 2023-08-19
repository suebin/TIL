import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] multiverse = new int[m][n];
        int[][] sortedMultiverse = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < n; j++) {
                multiverse[i][j] = sortedMultiverse[i][j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(sortedMultiverse[i]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                multiverse[i][j] = lowerBound(sortedMultiverse[i], multiverse[i][j]);
            }
        }

        int result = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                if (Arrays.equals(multiverse[i], multiverse[j])) {
                    result++;
                }
            }
        }

        System.out.print(result);
        reader.close();
    }

    private static int lowerBound(int[] arr, int num) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (num < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo - 1;
    }
}