class Solution {
    public long solution(int n, int[] times) {
        return binarySearch(n, times);
    }

    private static long binarySearch(int n, int[] times) {
        long min = 1;
        long max = (long) times[times.length - 1] * n;

        while (min < max) {
            long sum = 0;
            long mid = (min + max) / 2;

            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) max = mid;
            else min = mid + 1;
        }

        return min;
    }
}