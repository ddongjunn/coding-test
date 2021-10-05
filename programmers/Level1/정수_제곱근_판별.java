class Solution {
    public long solution(long n) {
        long answer = -1;
        double doubleSqrt = Math.sqrt(n);
        int intSqrt = (int) doubleSqrt;
        
        return intSqrt == doubleSqrt ? (long)Math.pow(intSqrt + 1,2) : -1;
    }
}