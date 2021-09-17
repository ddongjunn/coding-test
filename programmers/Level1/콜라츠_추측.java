class Solution {
    public int solution(int num){
        int a = num;
        int answer = 0;
        while(num!=1){
            if(num%2==0){
                num = num / 2;
                if(num <= 0){
                    num = a;
                }
            }else {
                num = (num * 3) + 1;
                if(num <= 0){
                    num = a;
                }
            }
            answer++;  



            if(answer>=500){
                answer = -1;
                break;
            }
        }
        return answer;
    }
}