import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

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
