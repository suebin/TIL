import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = reader.readLine().split("-");
        int answer = Integer.MAX_VALUE;

        for (String s : nums) {
            int sum = 0;
            String[] num = s.split("\\+");

            for (String n : num) {
                sum += Integer.parseInt(n);
            }

            if (answer == Integer.MAX_VALUE) {
                answer = sum;
            } else {
                answer -= sum;
            }
        }

        System.out.print(answer);
    }
}