import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isPrimeArr = new boolean[N+1];
        Arrays.fill(isPrimeArr, true);

        isPrimeArr[1] = false;

        for (int i = 2; i*i <= N+1 ; i++) {
            if (isPrimeArr[i]) {
                for (int j = i*i; j < N+1; j += i) {
                    isPrimeArr[j] = false;
                }
            }
        }

        for (int i=M; i<=N; i++) {
            if (isPrimeArr[i]) {
                bw.write(i + "\n");
                bw.flush();
            }
        }

        bw.close();
        br.close();
    }
}