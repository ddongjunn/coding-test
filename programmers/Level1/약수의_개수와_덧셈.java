class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        int num[] = new int[(right-left)+1];
        for(int i=0; i<num.length; i++){
            int count = 0;
            num[i] = left + i;

            for(int j=1; j<=num[i]; j++){
                if(num[i]%j==0){
                    count++;
                }
            }

            if(count%2==0){
                answer += num[i];
            }else{
                answer -= num[i];
            }
        }

        return answer;
    }
}