import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int     N;
    static int[][] inputs;
    static int     coloredCnt;
    static int     nonColoredCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        inputs = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(inputs, N, 0, 0);
        bw.write(nonColoredCnt + "\n" + coloredCnt);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void recursive(int[][] inputs, int n, int x, int y) {

        // 전부 동일 색상
        if (isSameColor(inputs, n, x, y)) {
            return;
        }

        int half = n / 2;
        recursive(inputs, half, x, y);
        recursive(inputs, half, x, y + half);
        recursive(inputs, half, x + half, y);
        recursive(inputs, half, x + half, y + half);
    }

    private static boolean isSameColor(int[][] inputs, int n, int x, int y) {
        int firstNum = inputs[x][y];

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (inputs[i][j] != firstNum)
                    return false;
            }
        }

        if (firstNum == 1) {
            coloredCnt++;
        } else {
            nonColoredCnt++;
        }

        return true;
    }
}