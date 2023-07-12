import java.util.*;
import java.io.*;

public class Main {
    static int[][] time = new int[1001][1001]; // ❓ 배열의 크기

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(reader.readLine());

        bfs(s, 1, 0);

        reader.close();
    }

    static void bfs(int s, int emojiCnt, int emojiOfClipboardCnt) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{emojiCnt, emojiOfClipboardCnt});
        time[emojiCnt][emojiOfClipboardCnt] = 0;

        int nowTime;
        while (!queue.isEmpty()) {
            int[] nowCnt = queue.poll();
            emojiCnt = nowCnt[0];
            emojiOfClipboardCnt = nowCnt[1];
            nowTime = time[emojiCnt][emojiOfClipboardCnt];

            if (emojiCnt == s) {
                System.out.println(nowTime);
                return;
            }

            // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다. (❓ 1 에서 범위 체크를 하지 않아도 되는 이유)
            if (time[emojiCnt][emojiCnt] == 0) {
                queue.add(new int[]{emojiCnt, emojiCnt});
                time[emojiCnt][emojiCnt] = nowTime + 1;
            }
            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (emojiOfClipboardCnt != 0 && emojiCnt + emojiOfClipboardCnt <= s) {
                if (time[emojiCnt + emojiOfClipboardCnt][emojiOfClipboardCnt] == 0) {
                    queue.add(new int[]{emojiCnt + emojiOfClipboardCnt, emojiOfClipboardCnt});
                    time[emojiCnt + emojiOfClipboardCnt][emojiOfClipboardCnt] = nowTime + 1;
                }
            }
            // 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (emojiCnt > 1 && time[emojiCnt - 1][emojiOfClipboardCnt] == 0) {
                queue.add(new int[]{emojiCnt - 1, emojiOfClipboardCnt});
                time[emojiCnt - 1][emojiOfClipboardCnt] = nowTime + 1;
            }
        }
    }
}