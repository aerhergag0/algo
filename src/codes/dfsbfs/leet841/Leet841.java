package codes.dfsbfs.leet841;

import java.util.List;

public class Leet841 {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] visited = new boolean[rooms.size()];

		dfs(rooms, 0, visited);

		for (boolean b : visited) {
			if (!b) return false;
		}

		return true;
	}

	private void dfs(List<List<Integer>> rooms, int idx, boolean[] visited) {

		visited[idx] = true;
		List<Integer> keys = rooms.get(idx);

		for (int i : keys) {
			if (visited[i] == false) {
				dfs(rooms, i, visited);
			}
		}
	}
}
