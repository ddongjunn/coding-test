
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
    boolean solution(String s) {
        if(s.length() == 0) return true;

        int pCount = 0;
        int yCount = 0;

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P'){
                pCount++;
            }else if(s.charAt(i)=='y'|| s.charAt(i) == 'Y'){
                yCount++;
            }            
        }

        if(pCount == 0 && yCount == 0) return true;

        if(pCount == yCount) return true;
        else return false;
    }
}