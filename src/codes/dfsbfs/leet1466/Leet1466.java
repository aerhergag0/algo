package codes.dfsbfs.leet1466;

import java.util.ArrayList;
import java.util.List;

public class Leet1466 {

	int answer = 0;

	public int minReorder(int n, int[][] connections) {
		List<List<int[]>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] connection : connections) {
			graph.get(connection[0]).add(new int[]{connection[1], 1});
			graph.get(connection[1]).add(new int[]{connection[0], 0});
		}

		boolean[] visited = new boolean[n];
		dfs(graph, visited, 0);

		return answer;
	}

	private void dfs(List<List<int[]>> graph, boolean[] visited, int currentCity) {
		visited[currentCity] = true;

		for (int[] neighbor : graph.get(currentCity)) {
			int nextCity = neighbor[0];
			int direction = neighbor[1];

			if (!visited[nextCity]) {
				if (direction == 1) {
					answer++;
				}
				dfs(graph, visited, nextCity);
			}
		}
	}

}
