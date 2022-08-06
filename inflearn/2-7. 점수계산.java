import java.util.Scanner;

public class Main {

    public int solution(int[] arr){
        int answer = 0;
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 1){
                cnt++;
            }else{
                cnt = 0;
            }
            answer += cnt;
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Main main = new Main();
        int len = scan.nextInt();
        int[] arr = new int[len];

        for(int i=0; i<len; i++){
            arr[i] = scan.nextInt();
        }

        System.out.println(main.solution(arr));
    }

}
