import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main{

    static int solution(int N, int[][]board, int M, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pos : moves){
            for(int i=0; i<N; i++){
                if(board[i][pos-1]!=0){ //인형을 만나는곳
                    int tmp=board[i][pos-1];
                    board[i][pos-1]=0;
                    if(!stack.isEmpty() && tmp == stack.peek()){
                        stack.pop();
                        answer += 2;
                    }else{
                        stack.push(tmp);
                    }
                    break; //인형을 뺀 경우 break
                }
    
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] board = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                board[i][j] = scan.nextInt();
            }
        }
        int M = scan.nextInt();
        int[] moves = new int[M];
        for(int i=0; i<M; i++){
            moves[i] = scan.nextInt();
        }
        System.out.println(solution(N, board, M, moves));
    }
}
