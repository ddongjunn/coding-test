import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static int solution(int[] arr, int x){
        int answer = 0;
        int left = 0;
        int right = arr.length - 1;
        Arrays.sort(arr);
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == x){
                answer++;
                left++;
                right--;
            }else if(sum > x){
                right--;
            }else{
                left++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        int x = scan.nextInt();
        System.out.println(solution(arr, x));
    }
}