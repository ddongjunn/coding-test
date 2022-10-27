import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[][]arr){
        int answer = 0;
        for(int i=1; i<=n; i++){ //학생번호 1부터n
            for(int j=1; j<=n; j++){
                int cnt = 0;
                for(int k=0; k<m; k++){ //k번째 시험
                    int pi = 0;
                    int pj = 0;
                    for(int s=0; s<n; s++){ //학생 번호 찾기
                        if(arr[k][s] == i) pi = s;
                        if(arr[k][s] == j) pj = s;
                    }
                    if(pi < pj) cnt++;
                }
                if(cnt == m) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //학생수
        int m = scan.nextInt(); //시험수

        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=scan.nextInt();
            }
        }
        System.out.println(main.solution(n, m, arr));
    }
}
