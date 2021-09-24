import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = 1;
        for(int i = 0; i < 3; i++ ){
            num *= scan.nextInt();
        }
        String strNum = num + "";

        int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for(int i = 0; i < strNum.length(); i++){
            arr[Integer.parseInt(String.valueOf(strNum.charAt(i)))] += 1;
        }

        for(int val : arr){
            System.out.println(val);
        }

    }
}
