import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] location = reader.readLine().split("");

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (location[i].equals("P")) {
                for (int j = i - k; j <= i + k; j++) {
                    if (j < 0 || j >= n) continue;

                    if (location[j].equals("H")) {
                        ans++;
                        location[j] = ".";
                        break;
                    }

                }
            }
        }

        System.out.print(ans);
    }
}