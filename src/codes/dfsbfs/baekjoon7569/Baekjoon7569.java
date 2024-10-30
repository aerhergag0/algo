package codes.dfsbfs.baekjoon7569;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon7569 {

	/* 가로 칸 수,세로 칸 수,높이 칸 수
	 * 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100
	 * */
	static int M, N, H;
	static int[][][]   graph;
	static int         answer = 0;
	static List<int[]> startLocation;

	public static void main(String[] args) throws IOException {

		M = readInt();
		N = readInt();
		H = readInt();

		graph         = new int[H][N][M];
		startLocation = new ArrayList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					int num = readInt();
					graph[i][j][k] = num;

					if (num == 1) {
						startLocation.add(new int[]{i, j, k});
					}
				}
			}
		}

		bfs();
		if (isTomatoAllRiped()) {
			System.out.println(answer - 1);
		} else {
			System.out.println(-1);
		}

	}

	private static void bfs() {
		ArrayDeque<int[]> deque = new ArrayDeque<>();

		for (int[] arr : startLocation) {
			deque.offerLast(arr);
		}

		int[] dx = {-1, 1, 0, 0, 0, 0};
		int[] dy = {0, 0, -1, 1, 0, 0};
		int[] dz = {0, 0, 0, 0, -1, 1};

		while (!deque.isEmpty()) {
			int[] xyz = deque.pollFirst();

			int x = xyz[0];
			int y = xyz[1];
			int z = xyz[2];

			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];

				if (nx < 0 || ny < 0 || nz < 0 || nx >= H || ny >= N || nz >= M) continue;
				if (graph[nx][ny][nz] == -1) continue;
				if (graph[nx][ny][nz] == 0) {
					graph[nx][ny][nz] = graph[x][y][z] + 1;
					deque.offerLast(new int[]{nx, ny, nz});
				}
			}
		}

	}

	private static boolean isTomatoAllRiped() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (graph[i][j][k] == 0) {
						return false;
					}
					answer = Math.max(answer, graph[i][j][k]);
				}
			}
		}
		return true;
	}

	private static int readInt() throws IOException {
		// 초기 값 읽기: 첫 숫자 문자 읽어서 정수로 변환
		int charInput = System.in.read();

		// 숫자가 아닌 문자는 건너뜀
		while (charInput <= 32) {
			charInput = System.in.read();
		}

		// 음수 처리
		boolean isNegative = charInput == '-';
		if (isNegative) {
			charInput = System.in.read(); // 음수면 다음 문자로 이동
		}

		// 첫 번째 숫자 처리 (n = 읽은 숫자 값)
		int n = charInput & 15;

		// 나머지 숫자 처리
		while ((charInput = System.in.read()) > 32) { // 공백이나 제어 문자 이전까지 숫자 처리
			n = (n << 3) + (n << 1) + (charInput & 15); // n * 10 + 읽은 숫자 값
		}

		// 음수이면 음수 값으로 변환
		return isNegative ? -n : n;
	}

}
