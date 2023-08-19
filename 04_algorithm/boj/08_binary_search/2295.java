import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] u = new int[n];

        for (int i = 0; i < n; i++) {
            u[i] = Integer.parseInt(reader.readLine());
        }

        List<Integer> sumList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sumList.add(u[i] + u[j]);
            }
        }

        Arrays.sort(u);
        Collections.sort(sumList);

        int result = 0;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                int num = u[i] - u[j];
                if (binarySearch(sumList, num) && u[i] > result) {
                    result = u[i];
                }
            }
        }

        System.out.println(result);
        reader.close();
    }

    private static boolean binarySearch(List<Integer> sumList, int num) {
        int lo = 0;
        int hi = sumList.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (num < sumList.get(mid)) {
                hi = mid - 1;
            } else if (num > sumList.get(mid)) {
                lo = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}


/**
 * HashSet 활용 풀이 (HashSet 이 200ms 정도 더 빠름).
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Set<Integer> u = new HashSet<>();

        for (int i = 0; i < n; i++) {
            u.add(Integer.parseInt(reader.readLine()));
        }

        Set<Integer> sumSet = new HashSet<>();

        for (int i : u) {
            for (int j : u) {
                sumSet.add(i + j);
            }
        }

        int result = 0;

        for (int i : u) {
            for (int j : u) {
                if (sumSet.contains(i - j)) {
                    result = Math.max(result, i);
                }
            }
        }

        System.out.println(result);
        reader.close();
    }
}