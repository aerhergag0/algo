package leetcode.dfsbfs.baekjoon1012;

import java.io.*;

public class Baekjoon1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] MNK = br.readLine().split(" ");

            int M = Integer.parseInt(MNK[0]);
            int N = Integer.parseInt(MNK[1]);
            int K = Integer.parseInt(MNK[2]);

            int[][] board = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                String[] s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                board[y][x] = 1;
            }

            int answer = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        dfs(board, i, j, visited);
                        answer++;
                    }
                }
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int[][] board, int row, int col, boolean[][] visited) {

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        if (board[row][col] == 1 && !visited[row][col]) {
            visited[row][col] = true;
            dfs(board, row + 1, col, visited);
            dfs(board, row, col + 1, visited);
            dfs(board, row - 1, col, visited);
            dfs(board, row, col - 1, visited);
        }
    }
}
