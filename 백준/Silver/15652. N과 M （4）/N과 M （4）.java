import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static int[] selected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[N];
        sb = new StringBuilder();

        backtracking(0, 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start) {
        if (depth == M) {
            for (int i=0; i<M; i++) {
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N ; i++) {
            selected[depth] = i;
            backtracking(depth+1, i);
        }
    }
}