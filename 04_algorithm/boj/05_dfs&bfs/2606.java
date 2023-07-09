import java.util.*;
import java.io.*;

/**
 * 1. BFS (리스트 이용 / 14276KB, 124ms) 풀이.
 */
public class Main {
    static List<List<Integer>> computers;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int computerCnt = Integer.parseInt(reader.readLine());
        int connectedComputersCnt = Integer.parseInt(reader.readLine());

        StringTokenizer st;
        computers = new ArrayList<>();

        for (int i = 0; i <= computerCnt; i++) {
            computers.add(new ArrayList<>());
        }

        visit = new boolean[computerCnt + 1];

        for (int i = 0; i < connectedComputersCnt; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers.get(a).add(b);
            computers.get(b).add(a);
        }

        int answer = getVirusComputerCnt(1);
        System.out.println(answer);
    }

    static int getVirusComputerCnt(int computerNum) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(computerNum);
        visit[computerNum] = true;

        int virusComputerCnt = 0;

        while (!queue.isEmpty()) {
            computerNum = queue.poll();

            for (int num : computers.get(computerNum)) {
                if (!visit[num]) {
                    queue.add(num);
                    visit[num] = true;
                    virusComputerCnt++;
                }
            }
        }

        return virusComputerCnt;
    }
}

/**
 * 2. DFS (인접행렬을 담은 배열 이용 / 14108KB, 124ms) 풀이. 
 */
public class Main {
    static int computerCnt;
    static boolean[][] connectionOfComputer;
    static boolean[] visit;
    static int virusComputerCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        computerCnt = Integer.parseInt(reader.readLine());
        int connectedComputersCnt = Integer.parseInt(reader.readLine());

        connectionOfComputer = new boolean[computerCnt + 1][computerCnt + 1];
        visit = new boolean[computerCnt + 1];

        StringTokenizer st;
        for (int i = 0; i < connectedComputersCnt; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            connectionOfComputer[a][b] = true;
            connectionOfComputer[b][a] = true;
        }

        int answer = dfs(1);
        System.out.println(answer);
        reader.close();
    }

    static int dfs(int computerNum) {
        visit[computerNum] = true;

        for (int i = 1; i <= computerCnt; i++) {
            if (!visit[i] && connectionOfComputer[computerNum][i]) {
                dfs(i);
                virusComputerCnt++;
            }
        }

        return virusComputerCnt;
    }
}
