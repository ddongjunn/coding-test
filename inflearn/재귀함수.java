
import java.util.Scanner;

public class Main{
    public static void DFS(int n){
        if(n == 0){
            return;
        }else{
            DFS(n-1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        DFS(n);
    }
}

/*
 * 스택프레임구조를 사용한다.
 * 
 * DFS(3) -> DFS(2) -> DFS(1) -> DFS(0)
 * 
 * DFS(0) - line7
 * DFS(1) - line6
 * DFS(2) - line6
 * DFS(3) - line6
 * 
 * DFS(1) - line6
 * DFS(2) - line6
 * DFS(3) - line6
 * 
 * DFS(2) - line6
 * DFS(3) - line6
 * 
 * DFS(3) - line6
 * 
 *  
 * System.out.println(n + " ");
 * DFS(n-1); 
 * 위 코드일 경우 출력 -> 3 2 1
 * 
 */
