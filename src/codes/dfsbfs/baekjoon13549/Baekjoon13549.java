package codes.dfsbfs.baekjoon13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Baekjoon13549 {

    static int N;
    static int K;
    static int[] visited;

    final static int INF = 999999999;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);
        visited = new int[100001];
        Arrays.fill(visited, INF);

        int answer = bfs();

        System.out.println(answer);

    }

    private static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        visited[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                return visited[cur];
            }

            int next1 = cur*2;
            int next2 = cur+1;
            int next3 = cur-1;

            if (next1 < 100001 && visited[next1] > visited[cur]) {
                q.offer(next1);
                visited[next1] = visited[cur];
            }

            if (next2 < 100001 && visited[next2] > visited[cur] + 1) {
                q.offer(next2);
                visited[next2] = visited[cur] + 1;
            }

            if (next3 >= 0 && visited[next3] > visited[cur] + 1) {
                q.offer(next3);
                visited[next3] = visited[cur] + 1;
            }


        }

        return -1;
    }
}
