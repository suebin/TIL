import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int ans = binarySearch(n, nums);
        System.out.println(ans);
    }

    private static int binarySearch(int n, int[] nums) {
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (true) {
                if (left == i) left++;
                if (right == i) right--;

                if (left >= right) break;

                if (nums[left] + nums[right] > nums[i]) {
                    right--;
                } else if (nums[left] + nums[right] < nums[i]) {
                    left++;
                } else {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}