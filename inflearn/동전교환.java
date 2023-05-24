import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main{
    static int n,m, answer = Integer.MAX_VALUE;
    static int[] coins;

    /**
     * @param level - 사용된 동전의 개수
     * @param sum - 동전의 총합(금액)
     */
    public static void dfs(int level, int sum){
        if(sum > m){
            return;
        }

        if(level >= answer){//answer보다 더 높은 level은 확인 할 필요가 없음
            return;
        }

        if(sum == m){
            answer = Math.min(answer, level);
        }else{
            for(int i=n-1; i>=0; i--){//큰 금액부터 확인
                dfs(level+1, sum+coins[i]);
            }
            // IntStream.rangeClosed(1, n)
            //     .mapToObj(i -> coins[n - i])
            //     .forEach(coin -> dfs(level + 1, sum + coin));
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = scan.nextInt();
        }
        Arrays.sort(coins);
        m = scan.nextInt();

        dfs(0,0);
        System.out.println(answer);
    }
}
