import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static String[][] board;
    private static List<int[]> teachers;
    private static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        board = new String[n][n];
        teachers = new ArrayList<>();
        isPossible = false;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = st.nextToken();
                if (board[i][j].equals("T")) {
                    teachers.add(new int[]{i, j});
                }
            }
        }

        dfs(0);
        System.out.print(isPossible ? "YES" : "NO");
    }

    private static void dfs(int depth) {
        if (depth == 3) {
            if (bfs(board)) isPossible = true;
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j].equals("X")) {
                    board[i][j] = "O";
                    dfs(depth + 1);
                    board[i][j] = "X";
                }
            }
        }
    }

    private static boolean bfs(String[][] board) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        for (int[] teacher : teachers) {
            for (int i = 0; i < 4; i++) {
                int nx = teacher[0] + dx[i];
                int ny = teacher[1] + dy[i];

                while (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (board[nx][ny].equals("O")) break;
                    if (board[nx][ny].equals("S")) return false;
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }

        return true;
    }
}