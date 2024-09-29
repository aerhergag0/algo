package leetcode.dfsbfs.leet1466;

public class Leet1466 {
	public int minReorder(int n, int[][] connections) {
		int[][] graph = new int[n][n];

		for (int i=0; i<n; i++) {
			int a = connections[i][0];
			int b = connections[i][1];

			graph[a][b] = 1;
			graph[b][a] = 1;
		}
	}

	private
}
