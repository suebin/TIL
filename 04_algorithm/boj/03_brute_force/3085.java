import java.io.*;

public class Main {
    private static char[][] board;
    private static int n;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String colors = reader.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = colors.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                rowSwap(i, j);
                check();
                rowSwap(i, j);

                colSwap(i, j);
                check();
                colSwap(i, j);

                if (max == n) {
                    System.out.println(max);
                    return;
                }
            }
        }

        System.out.println(max);
        reader.close();
    }

    private static void rowSwap(int i, int j) {
        char temp = board[i][j];
        board[i][j] = board[i][j + 1];
        board[i][j + 1] = temp;
    }

    private static void colSwap(int i, int j) {
        char temp = board[j][i];
        board[j][i] = board[j + 1][i];
        board[j + 1][i] = temp;
    }

    private static void check() {
        for (int i = 0; i < n; i++) {
            char preRowColor = board[i][0];
            char preColColor = board[0][i];

            int rowCnt = 1;
            int colCnt = 1;

            for (int j = 1; j < n; j++) {
                if (preRowColor == board[i][j]) {
                    rowCnt++;
                } else {
                    max = Math.max(max, rowCnt);
                    rowCnt = 1;
                }

                if (preColColor == board[j][i]) {
                    colCnt++;
                } else {
                    max = Math.max(max, colCnt);
                    colCnt = 1;
                }

                preRowColor = board[i][j];
                preColColor = board[j][i];
            }

            max = Math.max(max, rowCnt);
            max = Math.max(max, colCnt);
        }
    }
}