import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = makeSet(str1.toUpperCase());
        List<String> list2 = makeSet(str2.toUpperCase());

        int intersectionCount = 0;
        for(String str : list1) {
            if(list2.contains(str)) {
                intersectionCount++;
                list2.remove(str);
            }
        }
        
        list1.addAll(list2);
        if(list1.size() == 0) {
            return 65536;
        }

        return (int) ((double) intersectionCount / list1.size() * 65536);
    }

    public boolean isAlphabetic(String str) {
        for(char c : str.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }

    public List<String> makeSet(String str) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < str.length() - 1; i++) {
            String element = str.substring(i, i + 2);
            if(isAlphabetic(element)) {
                list.add(element);
            }
        }
        return list;
    }
}