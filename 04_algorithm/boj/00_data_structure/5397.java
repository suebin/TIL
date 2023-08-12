import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());

        Stack<Character> pre = new Stack<>();
        Stack<Character> post = new Stack<>();

        for (int i = 0; i < t; i++) {
            String keyLogger = reader.readLine();

            for (int j = 0; j < keyLogger.length(); j++) {
                switch (keyLogger.charAt(j)) {
                    case ('<'):
                        if (!pre.isEmpty()) post.push(pre.pop());
                        break;
                    case ('>'):
                        if (!post.isEmpty()) pre.push(post.pop());
                        break;
                    case ('-'):
                        if (!pre.isEmpty()) pre.pop();
                        break;
                    default:
                        pre.push(keyLogger.charAt(j));
                }
            }

            while (!pre.isEmpty()) {
                post.push(pre.pop());
            }

            while (!post.isEmpty()) {
                writer.write(post.pop());
            }

            writer.write('\n');
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}