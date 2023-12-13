import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        Egg[] eggs = new Egg[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(s, w);
        }

        breakEgg(0, 0, eggs);
        System.out.print(max);
    }

    private static void breakEgg(int depth, int brokenCnt, Egg[] eggs) {
        if (depth == n) {
            max = Math.max(max, brokenCnt);
            return;
        }

        if (eggs[depth].s <= 0 || brokenCnt == n - 1) { // 손에 든 계란이 깨졌거나 모든 계란이 이미 깨진 경우
            breakEgg(depth + 1, brokenCnt, eggs);
            return;
        }

        int nextBrokenCnt = brokenCnt;

        for (int i = 0; i < n; i++) {
            if (i == depth) continue;
            if (eggs[i].s <= 0) continue; // 이미 계란이 깨진 경우

            // 계란 치기
            eggs[depth].s -= eggs[i].w;
            eggs[i].s -= eggs[depth].w;

            if (eggs[depth].s <= 0) nextBrokenCnt++;
            if (eggs[i].s <= 0) nextBrokenCnt++;

            breakEgg(depth + 1, nextBrokenCnt, eggs);

            // 계란 원상복구
            eggs[depth].s += eggs[i].w;
            eggs[i].s += eggs[depth].w;
            nextBrokenCnt = brokenCnt;
        }
    }

    private static class Egg {
        int s;
        int w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
}