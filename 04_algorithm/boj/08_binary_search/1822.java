import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int na = Integer.parseInt(st.nextToken());
        int nb = Integer.parseInt(st.nextToken());

        int[] a = new int[na];
        int[] b = new int[nb];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < na; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < nb; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int cnt = 0;

        StringBuilder result = new StringBuilder();
        for (int num : a) {
            if (!binarySearch(b, num)) {
                cnt++;
                result.append(num).append(' ');
            }
        }

        System.out.println(cnt + "\n" + result);
        reader.close();
    }

    private static boolean binarySearch(int[] arr, int num) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (num < arr[mid]) {
                hi = mid - 1;
            } else if (num > arr[mid]) {
                lo = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}