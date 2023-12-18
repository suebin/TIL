import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[] nums;
    private static boolean[] visit;
    private static List<Integer> tempList;
    private static List<Integer> ansList;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        nums = new int[n + 1];
        visit = new boolean[n + 1];
        ansList = new ArrayList<>();
        tempList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (!ansList.contains(i)) {
                visit[i] = true;
                tempList.add(i);
                dfs(i, i);
                visit[i] = false;
                tempList.remove((Integer)i);
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(ansList.size()).append("\n");
        Collections.sort(ansList);
        for (int i : ansList) {
            answer.append(i).append("\n");
        }

        System.out.print(answer);
    }

    private static void dfs(int start, int num) {
        if (nums[num] == start) {
            ansList.addAll(tempList);
            return;
        }

        if (!visit[nums[num]] && !ansList.contains(nums[num])) {
            visit[nums[num]] = true;
            tempList.add(nums[num]);
            dfs(start, nums[num]);
            visit[nums[num]] = false;
            tempList.remove((Integer)nums[num]);
        }
    }
}