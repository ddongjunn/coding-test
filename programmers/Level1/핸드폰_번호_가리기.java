
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int n = 0;
        for(int i=0; i<phone_number.length(); i++){
            if(phone_number.length() - i == 4){
                n = i;
                break;
            }
        }

        for(int i=0; i<phone_number.length(); i++){
           if(n>i){
                answer += "*";
            }else{
                char ch = phone_number.charAt(i);
                answer += Character.toString(ch);}
        }
        return answer;
     }
}