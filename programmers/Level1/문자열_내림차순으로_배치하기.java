import java.util.*;

class Solution {
    public String solution(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        
        
        return new StringBuffer(new String(ch)).reverse().toString();
    }
}