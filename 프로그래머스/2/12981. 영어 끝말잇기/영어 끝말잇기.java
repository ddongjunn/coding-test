import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String word = words[i];
            int person = (i % n) + 1;
            int cycle = (i / n) + 1;

            if(!word.startsWith(prevWord.substring(prevWord.length() - 1))) {
                return new int[]{person, cycle};
            }

            if(usedWords.contains(word)) {
                return new int[]{person, cycle};
            }

            usedWords.add(word);
        }
        return new int[]{0, 0};
    }
}