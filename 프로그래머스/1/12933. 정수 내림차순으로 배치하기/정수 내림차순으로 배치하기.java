import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            pq.add(c - '0');
        }
        long t = 1;
        while (!pq.isEmpty()) {
            answer += pq.poll() * t;
            t*=10;
        }
        
        
        return answer;
    }
}