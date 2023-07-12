import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(int[] numbers) {

        String answer = IntStream.of(numbers)
                                .mapToObj(String::valueOf)
                                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                                .collect(Collectors.joining());
            
        if(answer.toString().startsWith("0")){
            return "0";
        }

        return answer;
    }
}