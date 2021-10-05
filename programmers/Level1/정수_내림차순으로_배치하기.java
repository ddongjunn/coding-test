class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String strNum = n + "";
        char[] charArr = strNum.toCharArray();
        
        for(int i = 0 ; i < charArr.length; i++){
            for(int j = i + 1; j < charArr.length; j++){
                if(charArr[i] - '0' < charArr[j] - '0'){
                    char temp = charArr[i];
                    charArr[i] = charArr[j];
                    charArr[j] = temp;
                }
            }
        }
        
        String str = new String(charArr);        
        return Long.parseLong(str);
    }
}