import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int x = scan.nextInt();

        //num만큼 수열 입력받기
        int arr[] = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = scan.nextInt();
        }

        //결과
        for(int i=0; i<arr.length; i++){
            if(arr[i] < x){
                System.out.print(arr[i] + " ");
            }
        }

    }
}
