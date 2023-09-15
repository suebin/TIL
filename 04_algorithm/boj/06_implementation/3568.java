import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        StringBuilder result = new StringBuilder();

        String defaultType = st.nextToken();

        while (st.hasMoreTokens()) {
            result.append(defaultType);

            String name = st.nextToken();
            for (int i = name.length() - 2; i >= 0; i--) {
                char c = name.charAt(i);

                if (c == '*' || c == '&') {
                    result.append(c);
                } else if (c == ']') {
                    result.append("[]");
                    i--;
                } else {
                    result.append(' ').append(name, 0, i + 1);
                    break;
                }
            }

            result.append(';').append('\n');
        }

        System.out.print(result);
        reader.close();
    }
}