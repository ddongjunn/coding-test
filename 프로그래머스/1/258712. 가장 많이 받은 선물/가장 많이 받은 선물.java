import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int len = friends.length;
        Map<String, Integer> friend = new HashMap<>();
        for(int i = 0; i < len; i++){
            friend.put(friends[i], i);
        }

        int[][] giftGraph = new int[len][len];
        int[] giftPoint = new int[len];
        for(String gift : gifts){
            StringTokenizer st = new StringTokenizer(gift);
            int send = friend.get(st.nextToken());
            int receive = friend.get(st.nextToken());

            giftGraph[send][receive]++;
            giftPoint[send]++;
            giftPoint[receive]--;
        }

        int[] nextMonthGift = new int[len];
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(giftGraph[i][j] > giftGraph[j][i]){
                    nextMonthGift[i]++;
                }else if(giftGraph[i][j] < giftGraph[j][i]){
                    nextMonthGift[j]++;
                }else{
                    if(giftPoint[i] > giftPoint[j]){
                        nextMonthGift[i]++;
                    }else if(giftPoint[i] < giftPoint[j]){
                        nextMonthGift[j]++;
                    }
                }
            }
        }

        Arrays.sort(nextMonthGift);
        return nextMonthGift[len - 1];
    }
}