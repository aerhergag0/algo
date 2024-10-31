package codes.dfsbfs.baekjoon11060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon11060 {

    static int N;
    static int[] maze;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // data input
        N = Integer.parseInt(br.readLine());
        maze = new int[N];
        visited = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        int answer = bfs();
        System.out.println(answer);


    }

    private static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = 1;
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                if (cur == N - 1) return depth;

                for (int k = 1; k <= maze[cur]; k++) {
                    int next = cur + k;
                    if (next < N && visited[next] == 0) {
                        visited[next] = visited[cur] + 1;
                        queue.offer(next);
                    }
                }
            }
            depth++;
        // end of while loop
        }

        return -1;
    }
}
