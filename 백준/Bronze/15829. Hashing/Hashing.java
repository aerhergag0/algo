import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        String input = br.readLine();

        BigInteger resultHash = new BigInteger("0");

        for (int i=0; i<input.length(); i++) {
            int a = input.charAt(i) - 96;

            resultHash = resultHash.add(BigInteger.valueOf(a).multiply(BigInteger.valueOf(31).pow(i)));
        }

        resultHash = resultHash.mod(BigInteger.valueOf(1234567891));

        bw.write(resultHash.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}