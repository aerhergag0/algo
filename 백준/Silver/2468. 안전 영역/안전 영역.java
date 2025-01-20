import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int     N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int maxHeight   = 0;
        int maxSafeArea = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (maxHeight < a)
                    maxHeight = a;
                map[i][j] = a;
            }
        }

        for (int i = 0; i < maxHeight; i++) {
            boolean[][] visited  = new boolean[N][N];
            int         safeArea = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && map[j][k] > i && dfs(visited, j, k, i))
                        safeArea++;
                }
            }

            if (safeArea > maxSafeArea) {
                maxSafeArea = safeArea;
            }
        }

        bw.write(String.valueOf(maxSafeArea));
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean dfs(boolean[][] visited, int x, int y, int height) {
        if (x < 0 || y < 0 || x >= N || y >= N)
            return false;
        if (visited[x][y] || map[x][y] <= height)
            return false;

        visited[x][y] = true;

        dfs(visited, x + 1, y, height);
        dfs(visited, x, y + 1, height);
        dfs(visited, x - 1, y, height);
        dfs(visited, x, y - 1, height);

        return true;
    }
}