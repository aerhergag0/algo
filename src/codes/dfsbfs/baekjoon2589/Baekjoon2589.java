package codes.dfsbfs.baekjoon2589;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2589 {

    static int rows, cols;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        board = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = br.readLine();
            for (int j = 0; j < cols; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int maxDistance = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'L') {
                    maxDistance = Math.max(maxDistance, bfs(i, j));
                }
            }
        }

        System.out.println(maxDistance - 1);
    }

    private static int bfs(int row, int col) {
        int[][] visited = new int[rows][cols];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        visited[row][col] = 1;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            maxDist = Math.max(maxDist, visited[x][y]);

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    if (visited[newX][newY] == 0 && board[newX][newY] == 'L') {
                        q.offer(new int[]{newX, newY});
                        visited[newX][newY] = visited[x][y] + 1;
                    }
                }
            }
        }

        return maxDist;
    }
}
