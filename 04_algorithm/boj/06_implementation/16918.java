import java.util.*;
import java.io.*;

public class Main {
    private static char[][] board;
    private static int[][] bombTime;
    private static int r;
    private static int c;
    private static int n;
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        settingBoard();

        int time = 0;

        while (time++ < n) {
            switch (time % 2) {
                case (0):
                    installBomb(time + 3);
                    break;
                case (1):
                    explodeBomb(time);
            }
        }

        printBoard();
    }

    private static void settingBoard() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        bombTime = new int[r][c];

        for (int i = 0; i < r; i++) {
            String status = reader.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = status.charAt(j);
                if (board[i][j] == 'O') bombTime[i][j] = 3;
            }
        }

        reader.close();
    }

    private static void installBomb(int time) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                {
                    if (board[i][j] == '.') {
                        board[i][j] = 'O';
                        bombTime[i][j] = time;
                    }
                }
            }
        }
    }

    private static void explodeBomb(int time) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (bombTime[i][j] == time) {
                    board[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;

                        if (board[nx][ny] == 'O' && bombTime[nx][ny] != time) {
                            board[nx][ny] = '.';
                            bombTime[nx][ny] = 0;
                        }
                    }
                }
            }
        }
    }

    private static void printBoard() {
        StringBuilder result = new StringBuilder();
        for (char[] row : board) {
            for (char status : row) {
                result.append(status);
            }
            result.append('\n');
        }

        System.out.print(result);
    }
}