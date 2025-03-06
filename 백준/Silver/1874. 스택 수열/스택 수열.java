import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] goals = new int[N];
        Stack<Integer> stack = new Stack<>();
        boolean isPossible = true;

        for (int i = 0; i < N; i++) {
            goals[i] = Integer.parseInt(br.readLine());
        }

        int count = 1;
        for (int i = 0; i < N; i++) {
            int target = goals[i];

            while (count <= target) {
                stack.push(count++);
                sb.append("+\n");
            }

            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}