import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        int minusCnt = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
            if (arr[i] <= 0) minusCnt++;
        }

        Arrays.sort(arr);

        int answer = 0;


        for (int i = 1; i < minusCnt; i += 2) {
            answer += (arr[i - 1] * arr[i]);
        }


        if (minusCnt % 2 == 1) { // 음수 (0 포함) 개수가 홀수인 경우
            answer += arr[minusCnt - 1];
        }

        if ((n - minusCnt) % 2 == 1) { // 양수 개수가 홀수인 경우
            answer += arr[minusCnt];
        }

        for (int i = n - 1; i > minusCnt; i -= 2) {
            int mul = arr[i] * arr[i - 1];
            int sum = arr[i] + arr[i - 1];
            answer += Math.max(mul, sum);
        }

        System.out.print(answer);
    }
}