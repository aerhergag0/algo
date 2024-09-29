package leetcode.dfsbfs.leet547;

public class Leet547 {
	public int findCircleNum(int[][] isConnected) {
		int answer = 0;

		boolean[] visited = new boolean[isConnected.length];

		for (int i = 0; i < isConnected.length; i++) {
			if (!visited[i]) {
				dfs(isConnected, visited, i);
				answer++;
			}
		}

		return answer;
	}

	private void dfs(int[][] graph, boolean[] visited, int idx) {
		visited[idx] = true;

		for (int i = 0; i < graph[idx].length; i++) {
			if (!visited[i] && graph[idx][i] == 1) {
				dfs(graph, visited, i);
			}
		}
	}
}
