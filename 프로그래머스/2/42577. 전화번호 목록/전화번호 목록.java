import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = Stream.of(phone_book).collect(Collectors.toSet());
        
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}