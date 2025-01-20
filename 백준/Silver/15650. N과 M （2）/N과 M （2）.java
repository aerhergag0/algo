import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static boolean[]            visited;
    static ArrayList<Integer> arrList;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arrList = new ArrayList<>();

        backtracking(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start) throws IOException {
        if (depth == M) {
            for (int num : arrList) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arrList.add(i+1);

                backtracking(depth+1, i+1);

                visited[i] = false;
                arrList.remove(arrList.size()-1);
            }
        }
    }
}