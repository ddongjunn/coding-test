class Solution {
    public int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for(int i : ingredient) {
            sb.append(i);
            
            int len = sb.length();
            if(len > 3
               && sb.charAt(len - 1) == '1'
               && sb.charAt(len - 2) == '3'
               && sb.charAt(len - 3) == '2'
               && sb.charAt(len - 4) == '1') 
            {
                sb.setLength(len - 4);
                ans++;
            }
        }
        
        return ans;
    }
}