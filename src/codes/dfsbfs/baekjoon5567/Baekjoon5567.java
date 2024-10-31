package codes.dfsbfs.baekjoon5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon5567 {

    static int n;
    static int m;
    static int[][] map;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // data input
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 1;
            map[b][a] = 1;
        }

        int answer = bfs();
        System.out.println(answer);
    }

    private static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        int depth = 1;
        int cnt = 0;
        q.offer(0);
        visited[0] = 1;

        while (!q.isEmpty() && depth <= 2) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int j = 0; j < n; j++) {
                    if (map[cur][j] == 1 && visited[j] == 0) {
                        cnt++;
                        q.offer(j);
                        visited[j] = 1;
                    }
                }
            }

            depth++;
        }

        return cnt;
    }
}
