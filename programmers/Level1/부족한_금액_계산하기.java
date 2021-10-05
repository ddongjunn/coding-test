class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long totalPrice = 0;
        
        for(int i = 1; i <= count; i++){
            totalPrice += (price * i);
        }
        
        if(totalPrice > money) answer = totalPrice - money;
        else answer = 0;

        return answer;
    }
}