import java.util.*;
import java.io.*;

public class Main {
    private static int m;
    private static List<int[]> partyList;
    private static int[] parents;
    private static boolean[] isTrue;

    public static void main(String[] args) throws IOException {
        if (!setting()) return;
        connectPartyPeople();
        checkTruePerson();
        System.out.print(getFalsePartyCnt());
    }

    private static int getFalsePartyCnt() {
        int truePartyCnt = 0;
        for (int[] list : partyList) {
            for (int i : list) {
                if (isTrue[i]) {
                    truePartyCnt++;
                    break;
                }
            }
        }

        return m - truePartyCnt;
    }

    private static void checkTruePerson() {
        for (int[] list : partyList) {
            for (int i : list) {
                if (isTrue[find(i)]) {
                    for (int j : list) {
                        isTrue[j] = true;
                    }
                    break;
                }
            }
        }
    }

    private static void connectPartyPeople() {
        for (int[] list : partyList) {
            for (int i = 0; i < list.length - 1; i++) {
                union(list[i], list[i + 1]);
            }
        }
    }

    private static boolean setting() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        partyList = new ArrayList<>();
        parents = new int[n + 1];
        isTrue = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(reader.readLine());
        int trueCnt = Integer.parseInt(st.nextToken());

        if (trueCnt == 0) {
            System.out.print(m);
            return false;
        }

        // 진실을 아는 사람 정보 저장
        for (int i = 0; i < trueCnt; i++) {
            isTrue[Integer.parseInt(st.nextToken())] = true;
        }

        // party 정보 리스트 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int num = Integer.parseInt(st.nextToken());
            partyList.add(new int[num]);

            for (int j = 0; j < num; j++) {
                partyList.get(i)[j] = Integer.parseInt(st.nextToken());
            }
        }

        return true;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parents[y] = x;
            if (isTrue[y]) isTrue[x] = true;
            return;
        }
        parents[x] = y;
        if (isTrue[x]) isTrue[y] = true;
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }
}