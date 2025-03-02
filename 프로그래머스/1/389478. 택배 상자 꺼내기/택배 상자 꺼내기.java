class Solution {
    public int solution(int n, int w, int num) {    
        int targetY = (num - 1) / w;
        int targetX;
        
        if (targetY % 2 == 0) {
            targetX = (num - 1) % w;
        } else {
            targetX = w - 1 - ((num - 1) % w);
        }
        
        int count = 1;
        
        for (int i = 1; i <= n; i++) {
            int y = (i - 1) / w;
            int x;
            
            if (y % 2 == 0) {
                x = (i - 1) % w;
            } else {
                x = w - 1 - ((i - 1) % w);
            }
            
            if (y > targetY && x == targetX) {
                count++;
            }
        }
        
        return count;
    }
}