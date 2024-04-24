import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        return Arrays.stream(s.split(" ", -1))
            .map(word -> {
                if(word.isEmpty()){
                    return "";
                }
                
                char firstWord = word.charAt(0);
                if (Character.isAlphabetic(firstWord)){
                    return Character.toUpperCase(firstWord) + word.substring(1).toLowerCase();
                } else {
                    return word.toLowerCase();
                }
            })
            .collect(Collectors.joining(" "));
    }
}