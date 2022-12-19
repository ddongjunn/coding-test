import java.util.Scanner;

public class Main{
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] chk;
    public void DFS(int v){
        if(v == n) answer++;
        else{
            for(int i=1; i<=n; i++){
                if(graph[v][i] == 1 && chk[i] == 0){ //갈수있는 정점인지 확인
                    chk[i] = 1;
                    DFS(i);
                    chk[i] = 0; //다시 돌아올때 0으로 체크 풀기
                }
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt(); //정점의 개수
        m = scan.nextInt(); //간선의 개수
        graph = new int[n+1][n+1];
        chk = new int[n+1]; 
        for(int i=0; i<m; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[a][b]=1;
        }
        chk[1] = 1; //출발점 check
        main.DFS(1);
        System.out.println(answer);
    }
}
