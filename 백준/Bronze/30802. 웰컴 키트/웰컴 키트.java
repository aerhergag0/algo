import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] sizes = br.readLine().split(" ");
        String[] TP = br.readLine().split(" ");
        int T = Integer.parseInt(TP[0]);
        int P = Integer.parseInt(TP[1]);

        int ans1 = 0;
        for (String size : sizes) {
            ans1 += (int) Math.ceil(Double.parseDouble(size) / T);
        }

        int ans2 = N / P;
        int ans3 = N - (ans2*P);

        bw.write(ans1 + "\n" + ans2 + " " + ans3);
        bw.flush();
        bw.close();
        br.close();
    }
}