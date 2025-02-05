import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int dangerCount = 0;

        int x = routes.length; // 로봇 수
        int n = points.length; // 운송 포인트 수
        int m = routes[0].length; // 운송 경로 수

        int[][]   currentPoints = new int[x][2]; // 현재 위치
        int[]     nextPoints    = new int[x]; // 다음 목표지
        boolean[] completed     = new boolean[x]; // 도착 완료한 로봇

        for (int i = 0; i < x; i++) {
            int pointIdx = routes[i][0] - 1;
            currentPoints[i] = points[pointIdx].clone();
            nextPoints[i] = 1;
        }

        while (!allCompleted(completed)) {
            Map<String, Integer> posCount = new HashMap<>();

            for (int i = 0; i < x; i++) {
                if (!completed[i]) {
                    String pos = currentPoints[i][0] + "," + currentPoints[i][1];
                    posCount.put(pos, posCount.getOrDefault(pos, 0) + 1);
                }
            }

            for (int count : posCount.values()) {
                if (count >= 2)
                    dangerCount++;
            }

            for (int i = 0; i < x; i++) {
                if (completed[i])
                    continue;

                int[] target = points[routes[i][nextPoints[i]] - 1];

                if (Arrays.equals(currentPoints[i], target)) {
                    nextPoints[i]++;
                    if (nextPoints[i] >= routes[i].length) {
                        completed[i] = true;
                        continue;
                    }
                    target = points[routes[i][nextPoints[i]] - 1];
                }

                if (currentPoints[i][0] != target[0]) {
                    currentPoints[i][0] += Integer.compare(target[0], currentPoints[i][0]);
                } else if (currentPoints[i][1] != target[1]) {
                    currentPoints[i][1] += Integer.compare(target[1], currentPoints[i][1]);
                }
            }

        }

        int answer = dangerCount;
        return answer;
    }

    private boolean allCompleted(boolean[] completed) {
        for (boolean c : completed) {
            if (!c)
                return false;
        }
        return true;
    }
}