import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] prev = new int[3];
        prev[0] = Integer.parseInt(st.nextToken());
        prev[1] = Integer.parseInt(st.nextToken());
        prev[2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] curr = new int[3];
            curr[0] = Math.min(prev[1], prev[2]) + R;
            curr[1] = Math.min(prev[0], prev[2]) + G;
            curr[2] = Math.min(prev[0], prev[1]) + B;

            prev = curr;
        }

        int answer = Math.min(prev[0], Math.min(prev[1], prev[2]));
        System.out.println(answer);
    }
}