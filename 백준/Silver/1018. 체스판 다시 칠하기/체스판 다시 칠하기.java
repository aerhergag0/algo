import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String inputBoard[][] = new String[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                inputBoard[i][j] = input.substring(j, j+1);
            }
        }

        int answer = Integer.MAX_VALUE;

        // Logic
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                answer = Math.min(answer, checkBoard(inputBoard, i, j));
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int checkBoard(String[][] inputBoard, int i, int j) {
        int caseStartB = 0;
        int caseStartW = 0;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (x % 2 == 0 && y % 2 == 1 && inputBoard[i+x][j+y].equals("B")) {
                    caseStartB++;
                }
                if (x % 2 == 1 && y % 2 == 0 && inputBoard[i+x][j+y].equals("B")) {
                    caseStartB++;
                }

                if (x % 2 == 0 && y % 2 == 0 && inputBoard[i+x][j+y].equals("W")) {
                    caseStartB++;
                }
                if (x % 2 == 1 && y % 2 == 1 && inputBoard[i+x][j+y].equals("W")) {
                    caseStartB++;
                }
            }
        }

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (x % 2 == 0 && y % 2 == 1 && inputBoard[i+x][j+y].equals("W")) {
                    caseStartW++;
                }
                if (x % 2 == 1 && y % 2 == 0 && inputBoard[i+x][j+y].equals("W")) {
                    caseStartW++;
                }

                if (x % 2 == 0 && y % 2 == 0 && inputBoard[i+x][j+y].equals("B")) {
                    caseStartW++;
                }
                if (x % 2 == 1 && y % 2 == 1 && inputBoard[i+x][j+y].equals("B")) {
                    caseStartW++;
                }
            }
        }

        return Math.min(caseStartB, caseStartW);
    }
}