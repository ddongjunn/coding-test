import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;


class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String phone : phone_book) {
            set.add(phone);
        }  
        
        for(String phone : phone_book) {
            for(int i = 0; i < phone.length(); i++) {
                if(set.contains(phone.substring(0, i))) { 
                    return false;
                }
            }
        }
        
        return true;
    }
}