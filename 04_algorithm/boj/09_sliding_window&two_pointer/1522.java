import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = reader.readLine().split("");
        int aCnt = 0;

        for (String s : arr) {
            if (s.equals("a")) aCnt++;
        }

        if (aCnt == arr.length) {
            System.out.print(0);
            return;
        }

        int pointer = 0;
        int answer = Integer.MAX_VALUE;

        while (pointer != arr.length) {
            int bCnt = 0;

            for (int i = pointer; i < pointer + aCnt; i++) {
                if (arr[i % arr.length].equals("b")) bCnt++;
            }

            answer = Math.min(answer, bCnt);
            pointer++;
        }

        System.out.print(answer);
    }
}