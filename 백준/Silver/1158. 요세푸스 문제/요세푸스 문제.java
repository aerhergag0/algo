import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> josephus = new ArrayDeque<>();
        List<Integer> answerList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            josephus.offerLast(i);
        }

        while (!josephus.isEmpty()) {
            for (int i = 0; i < K-1; i++) {
                josephus.offerLast(josephus.pollFirst());
            }

            answerList.add(josephus.pollFirst());
        }

        StringJoiner answer = new StringJoiner(", ", "<", ">");
        for (int ans : answerList) {
            answer.add(String.valueOf(ans));
        }
        System.out.println(answer);
    }
}
