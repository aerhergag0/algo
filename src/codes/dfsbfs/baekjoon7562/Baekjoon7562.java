package codes.dfsbfs.baekjoon7562;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7562 {

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());
            int[][] board = new int[l][l];
            int[][] visited = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int answer = bfs(startX, startY, endX, endY, board, visited);

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int startX, int startY,
                           int endX, int endY,
                           int[][] board, int[][] visited
    ) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = 1;

        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                if (x == endX && y == endY) {
                    return depth;
                }

                for (int j = 0; j < 8; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];

                    if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && visited[newX][newY] == 0) {
                        visited[newX][newY] = 1;
                        q.offer(new int[]{newX, newY});
                    }

                }
            }

            depth++;
        }


        return -1;
    }
}
