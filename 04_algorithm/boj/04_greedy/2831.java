import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader reader;
    private static List<Integer>[] men, women;
    private static int coupleCnt;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        men = makeList(n);
        women = makeList(n);
        coupleCnt = 0;

        match(0, 1);
        match(1, 0);

        System.out.println(coupleCnt);
    }

    private static void match(int manType, int womanType) {
        int manIdx = 0;
        int womanIdx = 0;

        while (manIdx < men[manType].size() && womanIdx < women[womanType].size()) {
            if (isCouple(manType, womanType, manIdx, womanIdx)) {
                coupleCnt++;
                manIdx++;
                womanIdx++;
            } else {
                if (manType == 0) womanIdx++;
                else manIdx++;

            }
        }
    }

    private static boolean isCouple(int manType, int womanType, int manIdx, int womanIdx) {
        return manType == 0 && men[manType].get(manIdx) < women[womanType].get(womanIdx)
                || womanType == 0 && women[womanType].get(womanIdx) < men[manType].get(manIdx);
    }

    private static List<Integer>[] makeList(int n) throws IOException {
        List<Integer>[] list = new List[2];

        for (int i = 0; i < 2; i++) {
            list[i] = new ArrayList();
        }

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (height > 0) list[0].add(height);
            else list[1].add(-height);
        }

        for (int i = 0; i < 2; i++) {
            Collections.sort(list[i]);
        }
        return list;
    }
}