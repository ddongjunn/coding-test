class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcd = gcd(n,m);
    
        answer[0] = gcd;
        answer[1] = (n * m / gcd);
        
        return answer;
    }   
        
    public int gcd(int n, int m){
        if(m == 0) return n;
        else return gcd(m, n % m);
    }    
}
