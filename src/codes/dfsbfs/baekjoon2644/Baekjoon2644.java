package codes.dfsbfs.baekjoon2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2644 {

    static int n;
    static int[][] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] goals = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new int[n];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        int answer = bfs(Integer.parseInt(goals[0]) - 1, Integer.parseInt(goals[1]) - 1);
        System.out.println(answer);
    }

    private static int bfs(int x, int y) {
        Queue<Integer> q = new ArrayDeque<>();

        int depth = 0;
        q.offer(x);
        visited[x] = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                if (cur == y) {
                    return depth;
                }

                for (int k = 0; k < n; k++) {
                    if (graph[cur][k] == 1 && visited[k] == 0) {
                        q.offer(k);
                        visited[k] = 1;
                    }
                }
            }
            depth++;
        }

        return -1;
    }
}
