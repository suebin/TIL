import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int headcount = getHeadcount(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(reader.readLine());
        }

        System.out.print(set.size() / (headcount - 1));
    }

    private static int getHeadcount(String s) {
        switch (s) {
            case "Y":
                return 2;
            case "F":
                return 3;
            case "O":
                return 4;
        }
        return 0;
    }
}