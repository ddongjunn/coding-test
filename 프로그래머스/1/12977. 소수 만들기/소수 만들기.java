class Solution {
    public int solution(int[] nums) {
        return findPrimeNumber(nums, 0, 0, 0);
    }

    public int findPrimeNumber(int[] nums, int sum, int count, int start) {
        if(count == 3) {
            return isPrime(sum) ? 1 : 0;
        }

        int res = 0;
        for(int i = start; i < nums.length; i++) {
            res += findPrimeNumber(nums, sum + nums[i], count + 1, i + 1);
        }
        return res;
    }

    public boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}