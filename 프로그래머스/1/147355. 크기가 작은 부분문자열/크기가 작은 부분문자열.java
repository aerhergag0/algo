class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for (int i=0; i<=t.length() - p.length(); i++) {
            answer += compare(t.substring(i,i+p.length()), p);  
        }
        
        return answer;
    }
    
    public int compare(String a, String b) {
        return Long.parseLong(a) <= Long.parseLong(b) ? 1 : 0;
    }
}