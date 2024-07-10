class Solution {
    public int solution(String s) {
        int ans = 0;
        while(s.length() > 1) {
            s = s.substring(getBalancedSubstringIndex(s));
            ans++;
        }
        return s.length() == 0 ? ans : ans + 1; 
    }
    
    public int getBalancedSubstringIndex(String s) {
        int x = s.charAt(0);
        int cntX = 1;
        int cntY = 0;
        
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == x) {
                cntX++;
            } else {
                cntY++;
            }
            
            if(cntX == cntY) {
                return cntX + cntY;
            }
        }
        return s.length();
    }
}