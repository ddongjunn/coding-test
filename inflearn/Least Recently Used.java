import java.util.Scanner;

public class Main{
    public static void solution(int size, int N, int[] job){
        int[] cache = new int[size];

        for(int x : job){
            int pos = -1;
            for(int i=0; i<size; i++){
                if(x == cache[i]){ //hit 판별, hit일 경우 idx값 변경
                    pos=i;
                }
            }

            if(pos == -1){//miss
                for(int i=size-1; i>0; i--){
                    cache[i] = cache[i-1];
                }
            }else{//hit
                for(int i=pos; i>0; i--){
                    cache[i] = cache[i-1];
                }
            } 
            cache[0] = x;
        }

        for(int i : cache) System.out.print(i + " ");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int n = scan.nextInt();
        int[] job = new int[n];
        for(int i=0; i<n; i++){
            job[i] = scan.nextInt();
        }
        solution(size, n, job);
        scan.close();
    }
}
