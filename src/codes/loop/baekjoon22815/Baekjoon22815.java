package codes.loop.baekjoon22815;

import java.io.*;

public class Baekjoon22815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            int maxDistance = 0;
            int maxX        = 0;
            int maxY        = 0;
            int dx          = 0;
            int dy          = 0;

            while (true) {
                String[] inputs = br.readLine().split(" ");
                int      x      = Integer.parseInt(inputs[0]);
                int      y      = Integer.parseInt(inputs[1]);

                if (x == 0 && y == 0)
                    break;

                dx += x;
                dy += y;
                int currentMaxDistance = dx * dx + dy * dy;

                if (currentMaxDistance > maxDistance ||
                        (currentMaxDistance == maxDistance && dx > maxX)) {
                    maxDistance = currentMaxDistance;
                    maxX = dx;
                    maxY = dy;
                }
            }

            bw.write(maxX + " " + maxY + "\n");

            N--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
