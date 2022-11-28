import java.util.Scanner;

public class Main{

    static int solution(int N, int M, int[] arr){
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=1; j<N; j++){
                if(arr[j-1] > arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp; 
                }
            }
        }

        int lt = 0;
        int rt = N-1;
        while(lt <= rt){
            int mid = (lt+rt)/2;
            if(arr[mid] == M){
                answer = mid+1;
                break;
            }
            if(arr[mid] > M) rt = mid-1;
            else lt = mid+1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scan.nextInt();
        }
        System.out.println(solution(N, M, arr));
    }
}
