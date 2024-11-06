package codes.dfsbfs.baekjoon11123;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] board = new char[H][W];
            boolean[][] visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    board[i][j] = s.charAt(j);
                }
            }

            int answer = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && board[i][j] == '#') {
                        dfs(i, j, board, visited);
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

    private static void dfs(int x, int y, char[][] board, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return;
        if (visited[x][y] || board[x][y] != '#') return;
        visited[x][y] = true;

        if (board[x][y] == '#') {
            dfs(x, y - 1, board, visited);
            dfs(x, y + 1, board, visited);
            dfs(x + 1, y, board, visited);
            dfs(x - 1, y, board, visited);
        }
    }
}
