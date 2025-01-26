import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(fibo(n)));
        bw.flush();
        bw.close();
    }

    private static long fibo(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        long dp1 = 1;
        long dp2 = 1;

        for (int i = 3; i <= n; i++) {
            long temp = dp1 + dp2;
            dp1 = dp2;
            dp2 = temp;
        }
        return dp2;
    }
}