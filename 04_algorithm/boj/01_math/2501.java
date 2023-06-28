import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nums = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(nums.nextToken());
        int k = Integer.parseInt(nums.nextToken());

        List<Integer> divisorList = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (i * i == n) {
                divisorList.add(i);
            } else if (n % i == 0) {
                divisorList.add(i);
                divisorList.add(n/i);
            }
        }

        int result = 0;

        if (divisorList.size() >= k) {
            Collections.sort(divisorList);
            result = divisorList.get(k-1);
        }

        System.out.print(result);
        reader.close();
    }
}