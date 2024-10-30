package codes.floydwarshall.baekjoon11403;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11403 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N + 1][N + 1];
        final int INF = 100000000;

        for (int[] g : graph) {
            Arrays.fill(g, INF);
        }

        for (int i = 1; i <= N; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                graph[i + 1][j + 1] = input == 1 ? 1 : INF;
            }
        }

        for (int k = 1; k < N + 1; k++) {
            for (int a = 1; a < N + 1; a++) {
                for (int b = 1; b < N + 1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                sb.append(graph[i][j] == INF ? 0 : 1);
                if (j < N) {
                    sb.append(" ");
                }
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
