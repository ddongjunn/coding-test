class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        
        return answer;
    }
}
/*
1 2 3 4 5 6 7 8
1 4 6 7
4 7
*/