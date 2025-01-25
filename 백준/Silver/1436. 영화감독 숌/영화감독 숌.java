import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        int cnt = 666;
        while (N > 0) {
            String str = Integer.toString(cnt);
            if (str.contains("666")) {
                N--;
            }

            cnt++;
        }

        System.out.println(cnt - 1);
    }
}
