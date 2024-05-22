import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int solution(String[][] clothes) {
        return Stream.of(clothes)
            .collect(Collectors.toMap(p -> p[1], p -> 1, Integer::sum))
            .values()
            .stream()
            .reduce(1, (x, y) -> x * (y + 1)) - 1;
    }
}