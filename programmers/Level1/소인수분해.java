import java.util.*;

public class Main{

    static int[] solution(int n) {
        Set<Integer> set = new TreeSet<Integer>();
        
        while(n>1){
            for(int i = 2 ; i <= n ; i++){
                if(n%i==0){
                    set.add(i);
                    n/=i;
                    break;
                }
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        solution(n);
    }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120852
