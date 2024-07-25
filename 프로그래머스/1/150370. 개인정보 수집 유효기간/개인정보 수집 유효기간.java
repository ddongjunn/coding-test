import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayInt = convertDateToInt(today);
        Map<String, Integer> termsMap = Arrays.stream(terms)
                .map(term -> term.split(" "))
                .collect(Collectors.toMap(
                        t -> t[0],
                        t -> Integer.parseInt(t[1])
                ));

        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            if(todayInt >= convertDateToInt(privacy[0]) + (termsMap.get(privacy[1]) * 28)) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int convertDateToInt(String date) {
        String[] d = date.split("\\.");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}