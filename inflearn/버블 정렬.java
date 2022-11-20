import java.util.Scanner;

public class Main{
    public static void solution(int N, int[] arr){
        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-1; j++){
                if(arr[j+1] < arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
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
버블정렬(Bubble Sort) - 이웃한 두 수를 비교해서 오름차순이면 index > index+1 이면 swap
1번의 trun을 통해서 swap
N-1 만큼만 도는 이유는 1번의 trun을 통해서 swap을 하는 경우 i+1의 값이 변경되기 떄문이다.
 */
