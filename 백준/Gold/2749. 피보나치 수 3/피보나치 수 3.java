import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger input = new BigInteger(br.readLine());
        int pisanoPeriod = 1_500_000;

        int reducedN = input.mod(BigInteger.valueOf(pisanoPeriod)).intValue();

        bw.write(String.valueOf(fibo(reducedN)));
        bw.flush();
        bw.close();
    }

    private static long fibo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;

        long dp1 = 1; // N[i-2]
        long dp2 = 1; // N[i-1]
        long dp3 = 2; // N[i]

        for (int i = 3; i <= n; i++) {
            dp3 = (dp1 + dp2) % 1_000_000;
            dp1 = dp2;
            dp2 = dp3;
        }

        return dp3;
    }
}
