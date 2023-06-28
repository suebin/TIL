import java.io.*;
import java.util.*;

public class Main {
    private static final int STATION = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nowCnt = 0;
        int max = 0;

        for (int i = 0; i < STATION; i++) {
            StringTokenizer nums = new StringTokenizer(reader.readLine());
            int outCnt = Integer.parseInt(nums.nextToken());
            int inCnt = Integer.parseInt(nums.nextToken());

            nowCnt += (inCnt - outCnt);
            max = Math.max(max, nowCnt);
        }
        System.out.print(max);
        reader.close();
    }
}