package codes.backtracking.baekjoon15649;

import java.io.*;

public class Baekjoon15649 {

    static int N;
    static int M;
    static boolean[] visited;
    static int[] sequence;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        visited = new boolean[N + 1];
        sequence = new int[M];  // 선택된 수열을 담을 배열
        sb = new StringBuilder();

        backtracking(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;  // 현재 depth 위치에 i 값 할당

                backtracking(depth + 1);

                visited[i] = false;  // 방문 해제
            }
        }
    }
}