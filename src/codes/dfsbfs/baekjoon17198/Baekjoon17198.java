package codes.dfsbfs.baekjoon17198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon17198 {

    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[10][10];
        visited = new boolean[10][10];
        int startX = 0, startY = 0;
        for (int i = 0; i < 10; i++) {
            String s = br.readLine();
            for (int j = 0; j < 10; j++) {
                board[i][j] = s.charAt(j);

                if (board[i][j] == 'L') {
                    startX = i;
                    startY = j;
                }
            }
        }

        int answer = bfs(startX, startY);
        System.out.println(answer-1);
    }

    private static int bfs(int startX, int startY) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int[] cur = deque.poll();
                int x = cur[0];
                int y = cur[1];

                if (board[x][y] == 'B') {
                    return depth;
                }

                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];

                    if (newX < 0 || newX >= 10 || newY < 0 || newY >= 10 || visited[newX][newY] || board[newX][newY] == 'R')
                        continue;

                    visited[newX][newY] = true;
                    deque.offer(new int[]{newX, newY});
                }
            }
            depth++;

        // end of while loop
        }
        return -1;
    }
}
