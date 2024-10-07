package leetcode.dfsbfs.baekjoon2178;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Baekjoon2178 {

	static int[][]             visited;
	static int                 n;
	static int                 m;
	static List<List<Integer>> graph = new ArrayList<>();
	static int[]               dx    = {-1, 1, 0, 0};
	static int[]               dy    = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] nm = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		n       = nm[0];
		m       = nm[1];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>(Arrays.stream(br.readLine().split(""))
					                          .map(Integer::parseInt)
					                          .collect(Collectors.toList()))
			);
		}

		bfs(0, 0);

		bw.write(String.valueOf(visited[n - 1][m - 1]));
		bw.flush();
		bw.close();
	}

	static class Location {
		int row;
		int col;

		public Location(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	private static void bfs(int x, int y) {
		Queue<Location> queue = new LinkedList<>();

		visited[x][y] = 1;
		queue.add(new Location(x, y));
		while (!queue.isEmpty()) {
			Location loc = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = loc.row + dx[i];
				int nextY = loc.col + dy[i];

				if (nextX < 0 || nextY < 0 || nextY >= m || nextX >= n) continue;

				if (graph.get(nextX).get(nextY) == 0 || visited[nextX][nextY] != 0) continue;

				visited[nextX][nextY] = visited[loc.row][loc.col] + 1;
				queue.add(new Location(nextX, nextY));
			}


		}

	}
}
