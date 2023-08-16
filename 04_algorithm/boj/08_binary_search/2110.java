import java.util.*;
import java.io.*;

public class Main {
    private static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(houses);

        int min = 1;
        int max = houses[n - 1] - houses[0] + 1;

        while (min < max) {
            int mid = (min + max) / 2;

            if (getInstallableCnt(mid) < c) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max - 1);
        reader.close();
    }

    private static int getInstallableCnt(int distance) {
        int cnt = 1;
        int lastLocation = houses[0];

        for (int location : houses) {
            if (location - lastLocation >= distance) {
                cnt++;
                lastLocation = location;
            }
        }

        return cnt;
    }
}