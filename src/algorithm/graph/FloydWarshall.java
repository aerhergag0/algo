package algorithm.graph;

import java.util.Arrays;

public class FloydWarshall {
	public static void main(String[] args) {
		int N = 4;
		int nodes = 7;

		int[][] graph = new int[N+1][N+1];

		for (int[] ints : graph) {
			Arrays.fill(ints, 100000000);
		}

		int[][] info = {
				{1, 2, 4},
				{1, 4, 6},
				{2, 1, 3},
				{2, 3, 7},
				{3, 1, 5},
				{3, 4, 4},
				{4, 3, 2}
		};

		// 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
		for (int i = 0; i < N; i++) {
			graph[i][i] = 0;
		}

		// 간선의 정보 입력받기
		for (int i = 0; i < nodes; i++) {
			graph[info[i][0]][info[i][1]] = info[i][2];
		}

		printArray(graph, "간선 입력 후 그래프");

		for (int k = 1; k < N+1; k++) {
			for (int a = 1; a < N+1; a++) {
				for (int b = 1; b < N+1; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}

		printArray(graph, "플로이드 워셜 알고리즘 후 그래프");

	}

	public static void printArray(int[][] graph, String message) {
		System.out.println(message);

		for (int[] row : graph) {
			for (int value : row) {
				if (value >= 100000000) {
					System.out.printf("%10s", "INF");
				} else {
					System.out.printf("%10d", value);
				}
			}
			System.out.println();
		}

		System.out.println("-------------------------------------------------------------");
	}
}
