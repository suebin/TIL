import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> list = fill(n, a, b);
        print(list, n);
    }

    private static void print(List<Integer> list, int n) {
        if (list.size() > n) {
            System.out.print(-1);
            return;
        }

        StringBuilder ans = new StringBuilder();
        for (int num : list) {
            ans.append(num).append(' ');
        }
        System.out.print(ans);
    }

    private static List<Integer> fill(int n, int a, int b) {
        List<Integer> list = new ArrayList<>();
        int maxHeight = Math.max(a, b); // 최대 높이
        list.add(maxHeight);

        int leftHeight = a - 1;
        int rightHeight = b - 1;

        while (leftHeight > 0) { // 최대 높이 기준 왼쪽 건물 높이 채우기
            list.add(0, leftHeight--);
        }

        int idx = a;
        while (rightHeight > 0) { // 최대 높이 기준 오른쪽 건물 높이 채우기
            list.add(idx++, rightHeight--);
        }

        while (list.size() < n) {
            if (a == 1) {
                list.add(1, 1);
                continue;
            }
            list.add(0, 1);
        }

        return list;
    }
}