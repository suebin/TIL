import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String bombS = reader.readLine();
        int bombSLen = bombS.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);

            if (stack.size() >= bombSLen) {
                boolean isBomb = true;

                for (int j = 0; j < bombSLen; j++) {
                    if (stack.get(stack.size() - bombSLen + j) != bombS.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    for (int j = 0; j < bombSLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (Character c : stack) {
            ans.append(c);
        }

        System.out.print(ans.length() == 0 ? "FRULA" : ans);
    }
}