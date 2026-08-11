class Solution {
    int count = 0;
    int answer = 0;
    public int solution(String word) {
        dfs(word, "");
        return answer;
    }
    
    public void dfs(String target, String current) {
        if (current.length() > 5) return;
        if (!current.equals("")) count++;
        if (current.equals(target)) answer = count;
        
        for (char ch : "AEIOU".toCharArray()) {
            dfs(target, current + ch);
        }
    }
}