import java.util.Scanner;

public class Main{
    public static void solution(int N, int[] arr){
        for(int i=1; i<N; i++){
            int tmp = arr[i];
            int j = 0;
            for(j=i-1; j>=0; j--){
                if(arr[j] > tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp; //1회전일때 j는 -1로 빠지기 때문에 j+1. 즉, j가 멈춘 지점 바로 뒤쪽에 tmp를 넣어준다.
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scan.nextInt();
        }
        solution(N, arr);
        scan.close();
    }
}

/*
 * 삽입정렬 - 앞에서부터 해당 원소가 위치 할 곳을 탐색하고 해당 위치에 삽입하는 것이다.
 * 
 * 1. 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교한다. (첫 번째 타겟은 두 번째 원소부터 시작한다.)
 * 2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 작다면 위치를 서로 교환한다.
 * 3. 그 다음 타겟을 찾아 위와 같은 방법으로 반복한다.
 * 
 */
