import java.util.*;

class Solution {
    private static Set<Integer>[] set;

    public int solution(int N, int number) {
        if (N == number) return 1;

        set = new HashSet[9];
        for (int i = 1; i <= 8; i++) {
            set[i] = new HashSet<>();
        }
        set[1].add(N);

        String num = Integer.toString(N);

        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                operate(i, j, i - j);
            }

            set[i].add(Integer.parseInt(num.repeat(i)));
            if (set[i].contains(number)) return i;
        }

        return -1;
    }

    private static void operate(int cur, int n1, int n2) {
        for (int x : set[n1]) {
            for (int y : set[n2]) {
                set[cur].add(x + y);
                set[cur].add(x * y);
                set[cur].add(x - y);
                if (y != 0) set[cur].add(x / y);
            }
        }
    }
}