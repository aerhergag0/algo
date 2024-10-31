package codes.dfsbfs.baekjoon9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Point[] maps = new Point[n + 2];
            int[] visited = new int[n + 2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            Point startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            maps[0] = startPoint;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                maps[i + 1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i + 1);
            }

            st = new StringTokenizer(br.readLine());
            Point endPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), n + 1);
            maps[n + 1] = endPoint;

            // End Input Data

            System.out.println(bfs(startPoint, endPoint, visited, maps) ? "happy" : "sad");
        }
    }

    private static boolean bfs(Point startPoint, Point endPoint, int[] visited, Point[] maps) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(startPoint);
        visited[startPoint.getIdx()] = 1;

        while (!q.isEmpty()) {
            Point currentPoint = q.poll();

            if (getDistance(currentPoint, endPoint) <= 1000) {
                return true;
            }

            for (int i = 0; i < maps.length; i++) {
                if (visited[maps[i].getIdx()] == 0 && getDistance(maps[i], currentPoint) <= 1000) {
                    q.offer(maps[i]);
                    visited[maps[i].getIdx()] = 1;
                }
            }

        }
        return false;
    }

    private static int getDistance(Point a, Point b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

    public static class Point {
        private int x;
        private int y;
        private int idx;

        public Point(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getIdx() {
            return idx;
        }
    }
}
