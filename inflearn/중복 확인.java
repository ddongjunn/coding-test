import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main{
    public static String solution(int N, int[] nums){
        String answer = "U";
        Set<Integer> set = new TreeSet<>();
        for(int i : nums) if(set.add(i) == false) return "D";
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++) nums[i] = scan.nextInt();
        System.out.println(solution(N, nums));
    }
}

//배열풀이 -- 시간초과
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static String solution(int N, int[] nums){
        String answer = "U";
        int[] arr = new int[N];
        
        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                if(nums[j] < nums[j-1]){
                    int tmp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        
        for(int i=0; i<N-1; i++){
            if(nums[i] == nums[i+1]) return "D";
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++) nums[i] = scan.nextInt();
        System.out.println(solution(N, nums));
    }
}

//배열풀이
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static String solution(int N, int[] nums){
        String answer = "U";
        Arrays.sort(nums);
        
        for(int i=0; i<N-1; i++){
            if(nums[i] == nums[i+1]) return "D";
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++) nums[i] = scan.nextInt();
        System.out.println(solution(N, nums));
    }
}
