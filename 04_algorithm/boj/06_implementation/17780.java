import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int k;
    private static int[][] chessBoard;
    private static ChessPiece[] chessPieces;
    private static List<Integer>[][] chessBoardStatus;
    private static final int[] CHANGE_DIR = {1, 0, 3, 2};
    private static final int[] DR = {0, 0, -1, 1};
    private static final int[] DC = {1, -1, 0, 0};
    private static final int RED = 1;
    private static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        gameSetting();
        System.out.println(playGame());
    }

    private static void gameSetting() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        chessBoard = new int[n][n];
        chessBoardStatus = new LinkedList[n][n];
        chessPieces = new ChessPiece[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = Integer.parseInt(st.nextToken());
                chessBoardStatus[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(reader.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;

            chessPieces[i] = new ChessPiece(row, col, dir);
            chessBoardStatus[row][col].add(i);
        }

        reader.close();
    }

    private static int playGame() {
        int turn = 0;
        boolean isGameDone = false;

        while (!isGameDone) {
            turn++;

            if (turn > 1000) break;

            for (int i = 0; i < k; i++) {
                ChessPiece chessPiece = chessPieces[i];

                int r = chessPiece.row;
                int c = chessPiece.col;

                if (chessBoardStatus[r][c].get(0) != i) continue;

                int nr = r + DR[chessPiece.dir];
                int nc = c + DC[chessPiece.dir];

                if (isOutOfMap(nr, nc) || chessBoard[nr][nc] == BLUE) {
                    chessPiece.dir = CHANGE_DIR[chessPieces[i].dir];
                    nr = r + DR[chessPiece.dir];
                    nc = c + DC[chessPiece.dir];
                }

                if (isOutOfMap(nr, nc) || chessBoard[nr][nc] == BLUE) {
                    continue;
                } else if (chessBoard[nr][nc] == RED) {
                    Collections.reverse(chessBoardStatus[r][c]);
                }

                move(r, c, nr, nc);

                if (chessBoardStatus[nr][nc].size() >= 4) {
                    isGameDone = true;
                    break;
                }
            }
        }

        return isGameDone ? turn : -1;
    }

    private static void move(int r, int c, int nr, int nc) {
        for (int pieceNum : chessBoardStatus[r][c]) {
            chessBoardStatus[nr][nc].add(pieceNum);
            chessPieces[pieceNum].row = nr;
            chessPieces[pieceNum].col = nc;
        }
        chessBoardStatus[r][c].clear();
    }

    private static boolean isOutOfMap(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= n || nc >= n;
    }

    private static class ChessPiece {
        int row;
        int col;
        int dir;

        public ChessPiece(int row, int col, int dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }
}