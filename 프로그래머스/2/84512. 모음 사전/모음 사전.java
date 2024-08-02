import java.util.ArrayList;
import java.util.List;

class Solution {
    
    static final char[] ALPHABET = {'A', 'E', 'I', 'O', 'U'};
    static List<String> dictionary = new ArrayList<>();
        
    public int solution(String word) {
        makeDic("");
        return dictionary.indexOf(word);
    }

    public void makeDic(String result){
        if(result.length() == 6) {
            return;
        }

        dictionary.add(result);

        for (char c : ALPHABET) {
            makeDic(result + c);
        }
    }
}