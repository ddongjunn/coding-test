import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int max = Arrays.stream(picks).map(i -> i * 5).sum();
        int limit = Math.min(max, minerals.length);

        List<int[]> blocks = new ArrayList<>();
        for (int idx = 0; idx < limit; idx += 5) {
            int d = 0;
            int i = 0;
            int s = 0;
            for (int j = idx; j < idx + 5 && j < limit; j++) {
                String mineral = minerals[j];
                if (mineral.equals("diamond")) d++;
                else if (mineral.equals("iron")) i++;
                else s++;
            }

            int hard = 25*d + 5*i + s;  // 돌 곡괭이 기준 피로도(=구간 난이도). 이 값으로 구간을 정렬한다.
            blocks.add(new int[]{d, i, s, hard});   // 난이도(hard) 내림차순: 어려운 구간에 좋은 곡괭이를 먼저 배치하기 위함
        }
        blocks.sort((a , b) -> b[3] - a[3]);

        //곡괭이 개수
        int diamond = picks[0];
        int iron = picks[1];
        int stone = picks[2];
        int answer = 0;
        for (int[] block : blocks) {
            // 현재 구간(최대 5개) 내 광물 개수: diamond/iron/stone
            int d = block[0];
            int i = block[1];
            int s = block[2];

            if (diamond > 0) {
                answer += d + i + s;
                diamond--;
            } else if (iron > 0) {
                answer += 5*d + i + s;
                iron--;
            } else if (stone > 0) {
                answer += 25*d + 5*i + s;
                stone--;
            } else {
                break;
            }
        }
        
        return answer;
    }
}
