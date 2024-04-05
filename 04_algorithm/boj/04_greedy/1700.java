import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] products = new int[k];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < k; i++) {
            products[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> multiTap = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < k; i++) {
            if (multiTap.contains(products[i])) continue;

            if (multiTap.size() < n) {
                multiTap.add(products[i]);
                continue;
            }

            int target = 0;
            int farthestIndex = 0;

            for (int cur : multiTap) {
                int index = 0;
                for (int j = i + 1; j < k; j++) {
                    if (cur == products[j]) {
                        index = j;
                        break;
                    }
                }

                if (index == 0) {
                    target = cur;
                    break;
                }
                farthestIndex = Math.max(farthestIndex, index);
            }

            multiTap.remove(target == 0 ? products[farthestIndex] : target);
            multiTap.add(products[i]);
            answer++;
        }

        System.out.print(answer);
    }
}