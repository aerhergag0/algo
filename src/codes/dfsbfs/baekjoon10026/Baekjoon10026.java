package codes.dfsbfs.baekjoon10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10026 {

    static int N;
    static char[][] board;
    static char[][] colorBlindBoard;
    static boolean[][] visited;
    static boolean[][] colorBlindVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        colorBlindBoard = new char[N][N];
        visited = new boolean[N][N];
        colorBlindVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
                if (s.charAt(j) == 'G' || s.charAt(j) == 'R') {
                    colorBlindBoard[i][j] = 'X';
                } else if (s.charAt(j) == 'B') {
                    colorBlindBoard[i][j] = 'B';
                }
            }
        } // End Data Input

        int ans1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, visited, board, board[i][j]);
                    ans1++;
                }
            }
        }

        int ans2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!colorBlindVisited[i][j]) {
                    dfs(i, j, colorBlindVisited, colorBlindBoard, colorBlindBoard[i][j]);
                    ans2++;
                }
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

    private static void dfs(int i, int j, boolean[][] visited, char[][] board, char color) {
        if (i < 0 || j < 0 || i >= N || j >= N) return;
        if (visited[i][j] || color != board[i][j]) return;

        visited[i][j] = true;

        dfs(i + 1, j, visited, board, board[i][j]);
        dfs(i - 1, j, visited, board, board[i][j]);
        dfs(i, j + 1, visited, board, board[i][j]);
        dfs(i, j - 1, visited, board, board[i][j]);
    }
}
