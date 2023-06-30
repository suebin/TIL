import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> setList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            setList.add(new HashSet<>());
        }
        setList.get(1).add(N);
        if (number == N) {
            return 1;
        }

        for (int i = 2; i < 9; i++) {
            for (int j = 1; j <= i / 2; j++) {
                operate(setList.get(i), setList.get(i - j), setList.get(j));
                operate(setList.get(i), setList.get(j), setList.get(i - j));
            }
            String n = Integer.toString(N);
            setList.get(i).add(Integer.parseInt(n.repeat(i)));

            if (setList.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }

    static void operate(Set<Integer> newSet, Set<Integer> set, Set<Integer> otherSet) {
        for (int num : set) {
            for (int otherNum : otherSet) {
                newSet.add(num + otherNum);
                newSet.add(num - otherNum);
                newSet.add(num * otherNum);

                if (otherNum != 0) {
                    newSet.add(num / otherNum);
                }
            }
        }
    }
}