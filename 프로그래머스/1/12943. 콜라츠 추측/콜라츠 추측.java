class Solution {
    public int solution(int num) {
        if (num == 1) {
            return 0;
        }
        
        int answer = 0;
        long num2 = num;
        
        while (answer < 500) {
           if (num2 % 2 == 0) {
               num2/=2;
           } else {
               num2=num2*3+1;
           }
            
            answer++;
            
            if (num2 == 1) {
                return answer;
            }
        }
        
        return -1;
    }
}