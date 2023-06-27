import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());

            int bitLocation = 0;
            StringBuilder result = new StringBuilder();
            while (n > 0) {
                if (n % 2 == 1) {
                    result.append(bitLocation).append(' ');
                }
                n /= 2;
                bitLocation++;
            }
            System.out.println(result);
        }
        reader.close();
    }
}