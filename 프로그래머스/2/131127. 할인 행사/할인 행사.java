import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = Arrays.stream(number).sum();
        Map<String, Integer> targetItems = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            targetItems.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length; i++) {
            Map<String, Integer> currentItems = new HashMap<>(targetItems);

            for (int j = i; j < i + days && j < discount.length; j++) {
                currentItems.put(discount[j], currentItems.getOrDefault(discount[j], 0) - 1);
            }

            if(hasNoRemainingItems(currentItems)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean hasNoRemainingItems(Map<String, Integer> map) {
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }
}