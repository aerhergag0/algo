import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] buildingTimes = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildingTimes[i] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> graph = new ArrayList<>();
            int[] inDegree = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
                inDegree[to]++;
            }

            int W = Integer.parseInt(br.readLine());


            ArrayDeque<Integer> queue = new ArrayDeque<>();
            
            int[] dp = new int[N + 1];
            Arrays.fill(dp, 0);

            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                    dp[i] = buildingTimes[i];
                }
            }

            while (!queue.isEmpty()) {
                int node = queue.poll();
                
                for (int neighbor : graph.get(node)) {

                    dp[neighbor] = Math.max(dp[neighbor], dp[node] + buildingTimes[neighbor]);
                    inDegree[neighbor]--;
                    
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            System.out.println(dp[W]);
        }
    }
}
