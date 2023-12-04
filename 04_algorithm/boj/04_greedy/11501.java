import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            int max = 0;
            long profit = 0;

            String[] nums = reader.readLine().split(" ");

            for (int j = n - 1; j >= 0; j--) {
                int num = Integer.parseInt(nums[j]);

                if (num > max) {
                    max = num;
                } else if (num < max) {
                    profit += (max - num);
                }
            }

            answer.append(profit).append("\n");
        }

        System.out.print(answer);
    }
}