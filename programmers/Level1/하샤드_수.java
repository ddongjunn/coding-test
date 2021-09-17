class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        String str = x + "";
        int sum = 0;

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            int y = (int)c - 48;
            sum += y; 
        }
        return x % sum == 0 ? true : false;
    }
}
