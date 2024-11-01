package codes.dfsbfs.baekjoon16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16928 {

    static int[] visited;
    static Map<Integer, Integer> jumps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        jumps = new HashMap<>();
        visited = new int[100];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            jumps.put(a, b);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            jumps.put(a, b);
        }

        int answer = bfs();
        System.out.println(answer);
    }

    private static int bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 99) {
                return visited[cur] - 1;
            }

            int nextPos = jumps.getOrDefault(cur, cur);

            for (int j = 1; j <= 6; j++) {
                int next = nextPos + j;
                if (next < 100 && visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    q.offer(next);
                }
            }
        }

        return -1;
    }
}
