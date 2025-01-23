import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        while (deque.size() != 1) {
            deque.pollFirst();
            deque.offerLast(deque.pollFirst());
        }

        bw.write(deque.peekFirst().toString());
        bw.flush();
        bw.close();
        br.close();
    }
}