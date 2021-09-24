import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arr[] = new int[9];

        for(int i = 0; i < arr.length; i++){
            arr[i] = scan.nextInt();
        }

        int num = 0;
        int index = 0;

        for(int i = 0; i < arr.length; i++){
            if(num < arr[i]){
                num = arr[i];
                index = (i + 1);
            }
        }
        System.out.print(num + "\n" + index);

    }
}
