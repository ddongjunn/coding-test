class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = Integer.MAX_VALUE; 

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPossible(diffs, times, limit, mid)) {
                right = mid; 
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isPossible(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            long currentTime = 0;

            if (diffs[i] <= level) {
                currentTime += times[i];
            } else {
                int mistakes = diffs[i] - level;
                int previousTime = (i > 0) ? times[i - 1] : 0;
                currentTime += (long) mistakes * (times[i] + previousTime) + times[i];
            }

            totalTime += currentTime;

            if (totalTime > limit) {
                return false;
            }
        }

        return totalTime <= limit;
    }
}