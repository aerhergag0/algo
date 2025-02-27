import java.io.*;
import java.util.*;

public class Main {

	// N : 세로 칸 수, M : 가로 칸 수
	static int N, M;
	static int[][]     graph;
	static int         answer;
	static List<int[]> startLocation;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = readInt();
		M = readInt();

		graph         = new int[M][N];
		startLocation = new ArrayList<>();
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				int num = readInt();
				graph[i][j] = num;

				if (num == 1) startLocation.add(new int[]{i, j});
			}
		}

		bfs();
		answer = countTomatoAllRiped() - 1;

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}

	private static int countTomatoAllRiped() {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (graph[i][j] == -1) {
					continue;
				} else if (graph[i][j] == 0) {
					return 0;
				} else {
					answer = Math.max(answer, graph[i][j]);
				}
			}
		}

		return answer;
	}

	private static void bfs() {
		ArrayDeque<int[]> deque = new ArrayDeque<>();

		for (int[] arr : startLocation) {
			deque.offerFirst(arr);
		}

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		while (!deque.isEmpty()) {
			int[] xy = deque.pollFirst();
			int x = xy[0];
			int y = xy[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if (graph[nx][ny] == -1) continue;
				if (graph[nx][ny] == 0) {
					graph[nx][ny] = graph[x][y] + 1;
					deque.add(new int[]{nx, ny});
				}
			}
		}
	}
    
    //////////////////////////////////////////////////
    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input<=32)
                return isNegative ? n * -1 : n;
            else if(input=='-')
                isNegative = true;
            else
                n = (n<<3) + (n<<1) + (input&15);
        }
    }
}
