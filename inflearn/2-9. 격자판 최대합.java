import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int arr[][] = new int[N][N];

        for(int i = 0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                arr[i][j] = scan.nextInt();
            }
        }

        Main main = new Main();
        main.solution(arr);
    }

    public void solution(int[][] arr){
        int answer = Integer.MIN_VALUE;
        int rowSum = 0;
        int colSum = 0;
        int diaSum = 0;

        for(int i=0; i<arr.length; i++){
            rowSum = 0;
            colSum = 0;
            for(int j=0; j<arr.length; j++){
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }
            answer = Math.max(answer, Math.max(rowSum, colSum));
        }

        for(int i=0; i<arr.length; i++){
            diaSum += arr[i][i];
        }

        System.out.println(Math.max(answer,diaSum));
    }
}


//반대쪽 대각선 합을 구하지 않아서 추가
import java.util.Scanner;

public class Main {
    public int solution(int n, int[][]arr){
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;

        for(int i=0; i<n; i++){
            sum1=sum2=0;
            for(int j=0; j<n; j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1=sum2=0;
        for(int i=0; i<n; i++){
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=scan.nextInt();
            }
        }

        System.out.println(main.solution(n, arr));
    }
}

