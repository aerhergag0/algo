import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final int CHESS_SIZE = 8;
    private static final char BLACK = 'B';
    private static final char WHITE = 'W';
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= N - CHESS_SIZE; i++) {
            for (int j = 0; j <= M - CHESS_SIZE; j++) {
                answer = Math.min(answer, checkBoard(board, i, j));
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int checkBoard(char[][] board, int startRow, int startCol) {
        int countStartWithBlack = countRepaints(board, startRow, startCol, BLACK);
        int countStartWithWhite = countRepaints(board, startRow, startCol, WHITE);
        
        return Math.min(countStartWithBlack, countStartWithWhite);
    }
    
    private static int countRepaints(char[][] board, int startRow, int startCol, char startColor) {
        int count = 0;
        char expectedColor = startColor;
        
        for (int i = 0; i < CHESS_SIZE; i++) {
            for (int j = 0; j < CHESS_SIZE; j++) {
                if (board[startRow + i][startCol + j] != expectedColor) {
                    count++;
                }
                expectedColor = (expectedColor == BLACK) ? WHITE : BLACK;
            }
            // 다음 행을 시작할 때는 시작 색상을 반대로
            expectedColor = (expectedColor == BLACK) ? WHITE : BLACK;
        }
        
        return count;
    }
}