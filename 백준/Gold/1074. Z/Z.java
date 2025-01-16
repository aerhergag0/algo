import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] Nrc = br.readLine().split(" ");
        int      N   = Integer.parseInt(Nrc[0]);
        int      r   = Integer.parseInt(Nrc[1]);
        int      c   = Integer.parseInt(Nrc[2]);

        int answer = zOrder(N, r, c);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int zOrder(int N, int r, int c) {
        if (N == 0) return 0;

        int size     = (int) Math.pow(2, N - 1);
        int quadSize = size * size;

        if (r < size && c < size) {
            return zOrder(N - 1, r, c);
        } else if (r < size && c >= size) {
            return quadSize + zOrder(N - 1, r, c - size);
        } else if (r >= size && c < size) {
            return 2 * quadSize + zOrder(N - 1, r - size, c);
        } else {
            return 3 * quadSize + zOrder(N - 1, r - size, c - size);
        }
    }
}