import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] strNums = s.split("},\\{");
        Arrays.sort(strNums, Comparator.comparingInt(String::length));

        Set<Integer> uniqueNumbers = new LinkedHashSet<>();
        for (String str : strNums) {
            Arrays.stream(str.split(","))
                    .mapToInt(Integer::parseInt)
                    .forEach(uniqueNumbers::add);
        }

        return uniqueNumbers.stream().mapToInt(Integer::intValue).toArray();
    }
}