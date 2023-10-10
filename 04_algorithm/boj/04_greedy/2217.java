import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(weights);
        int max = 0;

        for (int i = n; i > 0; i--) {
            int w = weights[n - i] * i;
            if (w > max) max = w;
        }

        System.out.print(max);
        reader.close();
    }
}