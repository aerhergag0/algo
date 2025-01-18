import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {

    static int     N;
    static int[][] meetings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int             a  = Integer.parseInt(st.nextToken());
            int             b  = Integer.parseInt(st.nextToken());

            meetings[i][0] = a;
            meetings[i][1] = b;
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count      = 0; // 회의 수
        int currentEnd = 0; // 현재 선택한 회의의 종료 시간

        for (int[] meeting : meetings) {
            if (meeting[0] >= currentEnd) {
                count++;
                currentEnd = meeting[1];
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}