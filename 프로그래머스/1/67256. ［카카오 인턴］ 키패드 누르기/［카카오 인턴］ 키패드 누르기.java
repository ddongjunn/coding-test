class Solution {
    public String solution(int[] numbers, String hand) {
        
        StringBuilder answer = new StringBuilder();
        
        int left = 10;
        int right = 12;
        for(int number : numbers) {
            if(number == 1 || number == 4 || number == 7) {
                answer.append("L");
                left = number;
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                right = number;
            } else {
                if (number == 0) {
                    number = 11;
                }
                
                int leftDiff = (Math.abs(number - left) / 3) + (Math.abs(number - left) % 3);
                int rightDiff = (Math.abs(number - right) / 3) + (Math.abs(number - right) % 3);
                
                if (leftDiff < rightDiff || (leftDiff == rightDiff && hand.equals("left"))) {
                    left = number;
                    answer.append("L");
                } else {
                    right = number;
                    answer.append("R");
                }
            }
        }
        return answer.toString();
    }
}