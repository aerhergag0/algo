package leetcode.dfsbfs.baekjoon11724;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] visited = new int[N];
        int[][] graph = new int[N][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(tokenizer.nextToken()) - 1;
            int y = Integer.parseInt(tokenizer.nextToken()) - 1;

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] == 0) {
//                    bfs(i, graph, visited);
                    dfs(i, graph, visited);
                    answer++;
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int current, int[][] graph, int[] visited) {
        visited[current] = 1;

        for (int i = 0; i < graph.length; i++) {
            if (graph[current][i] == 1 && visited[i] == 0) {
                dfs(i, graph, visited);
            }
        }
    }

    private static void bfs(int start, int[][] graph, int[] visited) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = 1;
        while (!q.isEmpty()) {
            int n = q.poll();

            for (int i = 0; i < graph.length; i++) {
                if (graph[n][i] == 1 && visited[i] == 0) {
                    q.offer(i);
                    visited[i] = 1;
                }
            }
        }
    }
}
