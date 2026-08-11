import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int startIdx = 0;
        
        Set<String> spoiler = new HashSet<>();
        Set<String> normal = new HashSet<>();   
        for (String msg : message.split(" ")) {
            int start = message.indexOf(msg, startIdx);
            int end = start + msg.length() - 1;
            startIdx = end;
            
            boolean isSpoiler = false;
            for (int[] range : spoiler_ranges) {
                if (start <= range[1] && range[0] <= end) {
                    isSpoiler = true;
                    break;
                }
            }
            
            if (isSpoiler) {
                spoiler.add(msg);
            } else {
                normal.add(msg);
            }
        }
        
        int count = 0;
        for (String str : spoiler) {
            if (!normal.contains(str)) {
                count++;
            }
        }

        return count;
    }
}
/**
단어는 공백으로 구분
단어를 구성하는 문자들의 인덱스 중 하나 이상이 스포 방지 구간에 포함될 경우 해당 단어는 스포일러 방지 단어
이전에 공개된 스포 방지 단어
여러 단어가 동시에 공개된 경우, 왼쪽부터 순서대로



           start====end
r[0]==r[1]              r[0]==r[1]

r[1] < start    end < r[0] -> 반대 조건 (겹치는 조건)

r[1] >= start end >= r[0]
*/