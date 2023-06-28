import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int min = 1000000;
        int max = -1000000;

        StringTokenizer nums = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(nums.nextToken());
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        System.out.print(min + " " + max);
        reader.close();
    }
}