import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> counts = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            counts.add(new HashSet<>());
        }

        if(N == number) {
            return 1;
        }

        counts.get(1).add(N);
        for(int i = 2; i < 9; i++) {
            Set<Integer> set = counts.get(i);

            for(int j = 1; j < i; j++) {
                Set<Integer> pre = counts.get(j);
                Set<Integer> post = counts.get(i - j);

                for(int num1 : pre) {
                    for(int num2 : post) {
                        set.add(num1 + num2);
                        set.add(num1 - num2);
                        set.add(num1 * num2);
                        if(num1 != 0 && num2 != 0) {
                            set.add(num1 / num2);
                        }
                    }
                }
            }
            set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for(Set<Integer> set : counts) {
            if(set.contains(number)){
                return counts.indexOf(set);
            }
        }

        return -1;
    }
}