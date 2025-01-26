import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int             N  = Integer.parseInt(st.nextToken());
        int             M  = Integer.parseInt(st.nextToken());
        int             K  = Integer.parseInt(st.nextToken());

        int    k      = (int) Math.ceil(Math.log(N) / Math.log(2));
        int    offset = (int) Math.pow(2, k);
        long[] tree   = new long[offset * 2];

        // 1.
        for (int i = 0; i < N; i++) {
            long input = Long.parseLong(br.readLine());
            tree[offset + i] = input;
        }

        for (int i = offset - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }


        // 2.
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            byte a = Byte.parseByte(st.nextToken());
            int  b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(tree, b, c, offset);
            } else if (a == 2) {
                long result = query(tree, b, c, offset);
                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void update(long[] tree, int b, long c, int offset) {
        // b번째 수를 c로 변경

        int p = offset + (b - 1);
        tree[p] = c;

        while (p > 1) {
            p /= 2;
            tree[p] = tree[p * 2] + tree[p * 2 + 1];
        }
    }

    private static long query(long[] tree, int b, long c, int offset) {
        // b번째 수부터 c번째 까지의 합 return

        int  left  = (b - 1) + offset;
        int  right = (int) ((c - 1) + offset);
        long sum   = 0;

        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left++];
            }

            if (right % 2 == 0) {
                sum += tree[right--];
            }

            left /= 2;
            right /= 2;
        }

        return sum;
    }
}
