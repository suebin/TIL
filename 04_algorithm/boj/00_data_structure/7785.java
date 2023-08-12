import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Set<String> set = new HashSet<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            String name = st.nextToken();
            String log = st.nextToken();

            if (log.equals("enter")) set.add(name);
            if (log.equals("leave")) set.remove(name);
        }

        StringBuilder result = new StringBuilder();

        set.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(name -> result.append(name).append('\n'));

        System.out.println(result);
        reader.close();
    }
}