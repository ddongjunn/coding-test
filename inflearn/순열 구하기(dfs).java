import java.util.Scanner;

class Main{
    static int N, M;
    static int[] pm, chk, arr;
    public static void dfs(int level){
        if(level == M){
            for(int x : pm){
                System.out.print(x + " ");
            }
            System.out.println();
        }else{
            for(int i=0; i<N; i++){
                if(chk[i] == 0){
                    chk[i] = 1;
                    pm[level] = arr[i];
                    dfs(level + 1);
                    chk[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
       
        pm = new int[M];  
        chk = new int[N];
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scan.nextInt();
        }

        dfs(0);
    }
}
