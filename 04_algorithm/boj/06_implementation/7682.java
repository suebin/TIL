import java.io.*;

public class Main {
    private static final int[][] idx = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // 가로
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // 세로
            {0, 4, 8}, {2, 4, 6} // 대각선
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        while (true) {
            String status = reader.readLine();

            if (status.equals("end")) break;

            char[] board = new char[9];
            int xCnt = 0;
            int oCnt = 0;
            int blankCnt = 0;

            for (int i = 0; i < status.length(); i++) {
                board[i] = status.charAt(i);

                if (board[i] == 'X') xCnt++;
                else if (board[i] == 'O') oCnt++;
                else blankCnt++;
            }

            int xSucceedCnt = getSucceedCnt(board, 'X');
            int oSucceedCnt = getSucceedCnt(board, 'O');

            if (isValid(xCnt, oCnt, blankCnt, xSucceedCnt, oSucceedCnt)) {
                ans.append("valid").append("\n");
            } else {
                ans.append("invalid").append("\n");
            }
        }

        System.out.println(ans);
    }

    private static boolean isValid(int xCnt, int oCnt, int blankCnt, int xSucceedCnt, int oSucceedCnt) {
        return xSucceedCnt == 1 && oSucceedCnt == 0 && xCnt == oCnt + 1 // X 가 이기는 경우
                || xSucceedCnt == 0 && oSucceedCnt == 1 && xCnt == oCnt // Y 가 이기는 경우
                || oSucceedCnt == 0 && blankCnt == 0 && xCnt == oCnt + 1; // 게임판이 가득 차는 경우 (X는 이길 수도 있지만, Y는 이기면 곧 Invalid)
    }

    private static int getSucceedCnt(char[] board, char turn) {
        int cnt = 0;
        for (int[] i : idx) {
            if (board[i[0]] == turn && board[i[1]] == turn && board[i[2]] == turn)
                cnt++;
        }
        return cnt;
    }
}