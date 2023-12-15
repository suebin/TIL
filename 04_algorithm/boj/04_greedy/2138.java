import java.io.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        /*
         0번째 : 처음 스위치를 킨 상태, 1번째 : 처음 스위치를 키지 않은 상태
         2번째 : 현재 상태, 3번째 : 만들고 싶은 상태
         */
        boolean[][] status = new boolean[4][n];
        int[] cnt = new int[2];

        int j = 0;
        for (String s : reader.readLine().split("")) {
            if (s.equals("1")) {
                status[0][j] = true;
                status[1][j] = true;
                status[2][j] = true;
            }
            j++;
        }

        j = 0;
        for (String s : reader.readLine().split("")) {
            if (s.equals("1")) status[3][j] = true;
            j++;
        }

        status[0][0] = !status[0][0];
        status[0][1] = !status[0][1];
        cnt[0]++;

        for (int i = 1; i < n; i++) {
            for (j = 0; j < 2; j++) {
                if (status[j][i - 1] != status[3][i - 1]) {
                    status[j][i - 1] = !status[j][i - 1];
                    status[j][i] = !status[j][i];
                    if (i != n - 1) status[j][i + 1] = !status[j][i + 1];
                    cnt[j]++;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            if (status[i][n - 1] != status[3][n - 1]) cnt[i] = INF;
        }

        int ans = Math.min(cnt[0], cnt[1]);
        System.out.print(ans == INF ? -1 : ans);
    }
}