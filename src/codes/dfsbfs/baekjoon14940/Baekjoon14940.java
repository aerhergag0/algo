package codes.dfsbfs.baekjoon14940;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon14940 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = readInt();
        int M = readInt();

        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];
        int[][] answer = new int[N][M];

        int startX = -1, startY = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = readInt();

                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
                if (map[i][j] == 1) {
                    answer[i][j] = -1;
                }
            }
        }

        bfs(startX, startY, visited, answer, map);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 1; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append(answer[i][M - 1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int startX, int startY, int[][] visited, int[][] answer, int[][] map) {
        Deque<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[]{startX, startY});
        visited[startX][startY] = 1;
        answer[startX][startY] = 0;

        while (!q.isEmpty()) {
            Integer[] cur = q.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length && visited[newX][newY] == 0 && map[newX][newY] == 1) {
                    visited[newX][newY] = 1;
                    answer[newX][newY] = answer[x][y] + 1;
                    q.add(new Integer[]{newX, newY});
                }
            }
        }
    }

    public static int readInt() throws IOException {
        int c = System.in.read(), n = 0, sign = 1;
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }
        do n = n * 10 + (c & 15);
        while ((c = System.in.read()) > 32);
        return n * sign;
    }
}
