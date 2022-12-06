
import java.util.Scanner;

public class Main{
    public static void DFS(int n){
        if(n == 0){ 
            return;
        }else{
            DFS(n/2);
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        DFS(n);
    }
}

/*
 *
 * 스택프레임구조를 사용한다.
 * 
 * DFS(0) - pop()
 * DFS(1) - line6
 * DFS(2) - line6
 * DFS(5) - line6
 * DFS(11) - line6
 * 
 */
