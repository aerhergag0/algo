package leetcode.dfsbfs.baekjoon18352;

import java.io.*;
import java.util.*;

public class Baekjoon18352 {

	static int N, M, K, X;
	static List<List<Integer>> graph;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;
		graph = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			graph.get(A).add(B);
		}

		distance = new int[N];
		Arrays.fill(distance, -1);

		TreeSet<Integer> result = bfs(X);

		if (result.isEmpty()) {
			bw.write("-1\n");
		} else {
			for (int city : result) {
				bw.write((city + 1) + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static TreeSet<Integer> bfs(int start) {
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offer(start);
		distance[start] = 0;

		TreeSet<Integer> result = new TreeSet<>();

		while (!deque.isEmpty()) {
			int current = deque.poll();

			for (int next : graph.get(current)) {
				if (distance[next] == -1) {
					distance[next] = distance[current] + 1;
					deque.offer(next);

					if (distance[next] == K) {
						result.add(next);
					}
				}
			}
		}
		return result;
	}
}
