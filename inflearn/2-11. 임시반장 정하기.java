import java.util.Scanner;

public class Main {
    public int solution(int n, int[][]arr){
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++){ //i = 학생번호
            int cnt = 0;
            for(int j=1; j<=n; j++){
                for(int k=1; k<=5; k++){ //학년
                    if(arr[i][k] == arr[j][k]){ //i번 학생의 k학년 == j 학생의 k학년
                        cnt++;  //i번 학생과 같은반을 한 j번 학생 cnt
                        break; //중요!!! 한명의 학생만 카운트
                    }
                }
            }
            if(cnt > max){
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n+1][6]; //1학년~5학년
        for(int i=1; i<=n; i++){ // i = 학생번호
            for(int j=1; j<=5; j++){
                arr[i][j]=scan.nextInt();
            }
        }

        System.out.println(main.solution(n, arr));
    }
}
