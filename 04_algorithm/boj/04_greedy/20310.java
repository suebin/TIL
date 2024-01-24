import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int len = s.length();
        char[] arr = new char[len];
        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 0; i < len; i++) {
            arr[i] = s.charAt(i);

            if (arr[i] == '1') oneCnt++;
            else zeroCnt++;
        }

        zeroCnt /= 2;
        oneCnt /= 2;

        int idx = 0;
        while (oneCnt != 0 && idx < len) {
            if (arr[idx] == '1') {
                arr[idx] = 'X';
                oneCnt--;
            }
            idx++;
        }

        idx = arr.length - 1;
        while (zeroCnt != 0 && idx >= 0) {
            if (arr[idx] == '0') {
                arr[idx] = 'X';
                zeroCnt--;
            }
            idx--;
        }

        StringBuilder ans = new StringBuilder();
        for (char c : arr) {
            if (c != 'X') ans.append(c);
        }

        System.out.print(ans);
    }
}