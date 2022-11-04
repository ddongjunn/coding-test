import java.util.Scanner;

public class Main {
    static int solution(int n, int m, int[] arr){
        int answer = 0;
        int cnt = 0;//0을 1로 바꾼 횟수
        int lt = 0;

        for(int rt=0; rt<n; rt++){
            if(arr[rt] == 0) cnt++;
            while(cnt > m){
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}

/*
최대 n만큼만 0 -> 1로 변경할수있다.
cnt : 0을 1로 바꾼 횟수
길이 : rt - lt + 1

lt = 0, rt =0
1. rt가 이동한곳을 0이면 1로 바꾼다고 생각하고,
2. cnt증가 - cnt는 0을 1로 바꾼 횟수 (즉, cnt는 m을 넘어갈 수 없다.)
3.  cnt > m일 경우 lt가 0을 찾아야한다. (cnt 1감소)
4. lt가 0을 만나면 lt,rt는 오른쪽으로 이동하고, rt가 바꾼 1을 0으로 다시 바꾼다.
5. rt가 이동했을때 1일경우 answer증가 - 길이(answer) = rt - lt + 1
 */
