import java.util.Scanner;

class Main{
    static int[] arr;
    static int n, m;

    public static void DFS(int L){
        if(L == m){
            for(int x : arr){
                System.out.print(x + " ");
                System.out.println();
            }
        }else{
            for(int i=1; i<=n; i++){
                arr[L] = i;
                DFS(L+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[m];
        DFS(0);
    }
}
