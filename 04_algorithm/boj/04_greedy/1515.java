import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int len = s.length();
        int num = 0;
        int point = 0;

        while (true) {
            num++;

            String sNum = String.valueOf(num);

            for (int i = 0; i < sNum.length(); i++) {
                if (s.charAt(point) == sNum.charAt(i)) point++;
                if (point == len) {
                    System.out.print(num);
                    return;
                }
            }
        }
    }
}