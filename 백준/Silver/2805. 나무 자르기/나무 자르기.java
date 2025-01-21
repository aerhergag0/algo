import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int result = findMaxHeight(trees,N, M);
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findMaxHeight(int[] trees, int N, int M) {
        int start = 0;
        int max = 0;
        int result = 0;

        for (int tree : trees) {
            if (max < tree) {
                max = tree;
            }
        }

        while (start <= max) {
            int mid = (start + max) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            if (sum >= M) {
                result = Math.max(result, mid);
                start = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return result;
    }
}