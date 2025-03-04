import java.io.*;
import java.util.*;

class Main {
    static int M, N, K;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] MNK = br.readLine().split(" ");
        M = Integer.parseInt(MNK[0]);
        N = Integer.parseInt(MNK[1]);
        K = Integer.parseInt(MNK[2]);

        board = new int[M][N];
        visited = new boolean[M][N];

        for (int i=0; i<K; i++) {
            String[] inputs = br.readLine().split(" ");

            int x1 = Integer.parseInt(inputs[0]);
            int y1 = Integer.parseInt(inputs[1]);
            int x2 = Integer.parseInt(inputs[2]);
            int y2 = Integer.parseInt(inputs[3]);

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    areas.add(bfs(i, j));
                }
            }
        }

        Collections.sort(areas);
        System.out.println(areas.size());
        for (int area : areas) {
            System.out.print(area + " ");
        }

    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int area = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && board[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        area++;
                    }
                }
            }
        }
        return area;
    }
}