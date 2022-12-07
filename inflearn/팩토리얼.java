import java.util.Scanner;

public class Main{
    public static int DFS(int n){
        if(n == 1) return 1;
        else return n * DFS(n-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(DFS(n));
    }
}
