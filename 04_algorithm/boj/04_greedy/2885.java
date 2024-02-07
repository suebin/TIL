import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());
        int size = getChocolateSize(k);

        System.out.print(size + " " + getCount(size, k));
    }

    private static int getChocolateSize(int k) {
        int size = 1;
        while (size < k) {
            size *= 2;
        }
        return size;
    }

    private static int getCount(int size, int k) {
        int sum = 0;
        int cnt = 0;
        while (size != k && sum != k) {
            size /= 2;
            if (sum + size <= k) sum += size;
            cnt++;
        }
        return cnt;
    }
}