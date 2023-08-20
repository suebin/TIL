import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(reader.readLine());

        int n = Integer.parseInt(reader.readLine());
        List<Long> partialSumA = getPartialSum(n);

        int m = Integer.parseInt(reader.readLine());
        List<Long> partialSumB = getPartialSum(m);

        Collections.sort(partialSumA);
        Collections.sort(partialSumB);

        long cnt = 0;
        for (int i = 0; i < partialSumA.size(); ) {
            long a = partialSumA.get(i);
            long b = t - a;

            long cntA = upperBound(partialSumA, a) - lowerBound(partialSumA, a);
            long cntB = upperBound(partialSumB, b) - lowerBound(partialSumB, b);

            cnt += cntA * cntB;
            i += cntA;
        }

        System.out.println(cnt);
        reader.close();
    }

    private static int lowerBound(List<Long> list, long num) {
        int lo = 0;
        int hi = list.size();

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (num <= list.get(mid)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private static int upperBound(List<Long> list, long num) {
        int lo = 0;
        int hi = list.size();

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (num < list.get(mid)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private static List<Long> getPartialSum(int num) throws IOException {
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Long> partialSum = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            long sum = 0;
            for (int j = i; j < num; j++) {
                sum += arr[j];
                partialSum.add(sum);
            }
        }

        return partialSum;
    }
}

/**
 * HashMap 풀이 (300ms 더 빠름).
 */
public class Main {
    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(reader.readLine());

        int n = Integer.parseInt(reader.readLine());
        Map<Long, Long> partialSumA = getPartialSum(n);

        int m = Integer.parseInt(reader.readLine());
        Map<Long, Long> partialSumB = getPartialSum(m);

        long cnt = 0;
        for (long a : partialSumA.keySet()) {
            long b = t - a;
            cnt += partialSumA.get(a) * partialSumB.getOrDefault(b, 0L);
        }

        System.out.println(cnt);
        reader.close();
    }

    private static Map<Long, Long> getPartialSum(int num) throws IOException {
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Long, Long> partialSum = new HashMap<>();

        for (int i = 0; i < num; i++) {
            long sum = 0;
            for (int j = i; j < num; j++) {
                sum += arr[j];
                partialSum.put(sum, partialSum.getOrDefault(sum, 0L) + 1);
            }
        }

        return partialSum;
    }
}