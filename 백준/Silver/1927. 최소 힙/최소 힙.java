import java.io.*;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input != 0) {
                pq.offer(input);
                continue;
            }

            bw.write((pq.isEmpty() ? 0 : pq.poll()) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}