import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] arr = new int[2 * n];

        for(int i = 0; i < n; i++) {
            arr[i] = elements[i];
            arr[i + n] = elements[i];
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                sum += arr[i + j];
                set.add(sum);
            }
        }
        return set.size();
    }
}