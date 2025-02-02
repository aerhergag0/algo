import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int dp1 = 1;
        int dp2 = 3;
        int answer = 0;

        if (N == 1) {
            answer = dp1;
        } else if (N == 2) {
            answer = dp2;
        } else {
            for (int i = 3; i <= N; i++) {
                answer = (dp1 * 2 + dp2) % 10_007;
                dp1 = dp2;
                dp2 = answer;
            }
        }
        System.out.println(answer);
    }
}
