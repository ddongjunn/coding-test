import java.util.*;

public class Main {
    static int solution(int N, int K, int[] arr){
        int answer = -1;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                for(int l=j+1; l<N; l++){
                    set.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        int cnt=0;
        for(int x : set){
            cnt++;
            if(cnt == K) return x;

        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scan.nextInt();
        }
        System.out.println(solution(N, K, arr));
    }
}

/*
N장의 카드 같은 숫자의 카드가 여러장 있을 수 있다.
N장의 카드 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록

N개의 합 경우의수를 set에 넣어주기
 */
