class Solution {
    static int[] memoization;
    
    public int solution(int n) {
        memoization = new int[1000001];    
        return fibonacci(n);
    }
    
    public static int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        
        if(memoization[n] != 0){
            return memoization[n];
        }
        
        return memoization[n] = (fibonacci(n - 2) + fibonacci(n - 1)) % 1234567;
    }
}