class Solution {
    public String solution(int[] food) {
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            for(int j = 0; j < count; j++){
                sb.append(i);
            }
        }

        String player1 = sb.toString();
        String player2 = sb.reverse().toString();        
        return new StringBuffer().append(player1)
            .append(0)
            .append(player2)
            .toString();        
    }
}