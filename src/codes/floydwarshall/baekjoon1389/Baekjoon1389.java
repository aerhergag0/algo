package codes.floydwarshall.baekjoon1389;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][N + 1];

        for (int[] g : graph) {
            Arrays.fill(g, 100000000);
        }

        for (int i = 0; i < N + 1; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int a = 1; a < N + 1; a++) {
                for (int b = 1; b < N + 1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int baconNum = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 1; i < N + 1; i++) {
            int sum = 0;
            for (int j = 1; j < N + 1; j++) {
                sum += graph[i][j];
            }

            if (sum < baconNum) {
                baconNum = sum;
                idx = i;
            }
        }

        bw.write(String.valueOf(idx));
        bw.flush();
        bw.close();
        br.close();
    }
}
