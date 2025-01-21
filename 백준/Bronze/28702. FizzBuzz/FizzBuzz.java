import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        
        int answerNum = 0;
        if (isNumber(a)) {
            answerNum = Integer.parseInt(a) + 3;
        } else if (isNumber(b)) {
            answerNum = Integer.parseInt(b) + 2;
        } else if (isNumber(c)) {
            answerNum = Integer.parseInt(c) + 1;
        }

        String answer = String.valueOf(answerNum);
        
        if (answerNum % 15 == 0) {
            answer = "FizzBuzz";
        } else if (answerNum % 5 == 0) {
            answer = "Buzz";
        } else if (answerNum % 3 == 0) {
            answer = "Fizz";
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isNumber (String s) {
        return !s.equals("Fizz") && !s.equals("Buzz") && !s.equals("FizzBuzz");
    }
}