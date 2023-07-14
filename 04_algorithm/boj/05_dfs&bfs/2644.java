import java.io.*;
import java.util.*;

/**
 * BFS.
 */
public class Main {
    private static int n;
    private static boolean[][] relationship;
    private static int[] degreeOfRelationship; // 촌 수를 배열로 저장

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(reader.readLine());
        relationship = new boolean[n + 1][n + 1];
        degreeOfRelationship = new int[n + 1];

        st = new StringTokenizer(reader.readLine());
        int targetPerson1 = Integer.parseInt(st.nextToken());
        int targetPerson2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());

            relationship[person1][person2] = true;
            relationship[person2][person1] = true;
        }

        int answer = getDegreeOfRelationship(targetPerson1, targetPerson2);

        System.out.print(answer);
    }

    private static int getDegreeOfRelationship(int person, int targetPerson) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(person);

        while (!queue.isEmpty()) {
            person = queue.poll();

            if (person == targetPerson) return degreeOfRelationship[targetPerson];

            for (int i = 1; i <= n; i++) {
                if (relationship[person][i] && degreeOfRelationship[i] == 0) {
                    queue.offer(i);
                    degreeOfRelationship[i] = degreeOfRelationship[person] + 1;
                }
            }
        }

        return -1;
    }
}

/**
 * DFS.
 */
public class Main {
    private static int n;
    private static boolean[][] relationship;
    private static int[] degreeOfRelationship;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(reader.readLine());
        relationship = new boolean[n + 1][n + 1];
        degreeOfRelationship = new int[n + 1];

        st = new StringTokenizer(reader.readLine());
        int person = Integer.parseInt(st.nextToken());
        int targetPerson = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());

            relationship[person1][person2] = true;
            relationship[person2][person1] = true;
        }

        dfs(person, targetPerson);

        int answer = degreeOfRelationship[targetPerson] == 0 ? -1 : degreeOfRelationship[targetPerson];
        System.out.print(answer);
    }

    private static void dfs(int person, int targetPerson) {
        if (person == targetPerson) return;

        for (int i = 1; i <= n; i++) {
            if (relationship[person][i] && degreeOfRelationship[i] == 0) {
                degreeOfRelationship[i] = degreeOfRelationship[person] + 1;
                dfs(i, targetPerson);
            }
        }
    }
}

/**
 * DFS - 2.
 */
public class Main {
    private static int n;
    private static boolean[] visit;
    private static boolean[][] relationship;
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(reader.readLine());
        visit = new boolean[n + 1];
        relationship = new boolean[n + 1][n + 1];

        st = new StringTokenizer(reader.readLine());
        int person = Integer.parseInt(st.nextToken());
        int targetPerson = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());

            relationship[person1][person2] = true;
            relationship[person2][person1] = true;
        }

        dfs(person, targetPerson, 0);

        System.out.print(answer);
    }

    private static void dfs(int person, int targetPerson, int degreeOfRelationship) {
        if (person == targetPerson) {
            answer = degreeOfRelationship;
            return;
        }

        visit[person] = true;
        for (int i = 1; i <= n; i++) {
            if (relationship[person][i] && !visit[i]) {
                dfs(i, targetPerson, degreeOfRelationship + 1);
            }
        }
    }
}