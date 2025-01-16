import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int   T  = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 3;

        int currentDP = 5;

        while (T-- > 0) {
            int input = Integer.parseInt(br.readLine());

            while (input >= currentDP) {
                solveDP(dp, currentDP);
                currentDP++;
            }

            bw.write(dp[input] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void solveDP(long[] arr, int n) {
        if (arr.length == 0) return;

        arr[n] = arr[n-5] + arr[n-4] + arr[n-3];
    }
}