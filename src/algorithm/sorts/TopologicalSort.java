package algorithm.sorts;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int vertices = 6;
        List<int[]> edges = Arrays.asList(
                new int[]{5, 2},
                new int[]{5, 0},
                new int[]{4, 0},
                new int[]{4, 1},
                new int[]{2, 3},
                new int[]{3, 1}
        );

        try {
            List<Integer> sortedOrder = topologicalSort(vertices, edges);
            System.out.println("위상 정렬 결과: " + sortedOrder);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Integer> topologicalSort(int vertices, List<int[]> edges) {
        // 1. 그래프와 진입 차수 배열 초기화
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            inDegree[to]++;
        }

        // 2. 진입 차수가 0인 노드를 큐에 추가
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 3. 위상 정렬 수행
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // 4. 사이클 여부 확인
        if (result.size() != vertices) {
            throw new IllegalStateException("Cycle detected in the graph!");
        }

        return result;
    }
}

