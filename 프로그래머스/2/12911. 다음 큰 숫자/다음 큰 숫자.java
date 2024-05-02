class Solution {
    public int solution(int n) {
        int nOfOne = Integer.bitCount(n);

        while(true){
            int nextNumber = n + 1;
            if(nOfOne == Integer.bitCount(nextNumber)){
                return nextNumber;
            }
            n = nextNumber;
        }
    }
}