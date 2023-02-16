import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int v){
        if(v == n){
            answer++;
        }else{
            for(int nv : graph.get(v)){//v번 arrayList
                if(ch[nv] == 0){
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){//정점 갯수만큼 리스트 객체를 만든다.
            graph.add(new ArrayList<Integer>()); 
        }
        ch = new int[n+1];
        for(int i=0; i<m; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}

/*
 * 정점이 클 경우 리스트 활용
 * 정점 갯수만큼 리스트 객체를 만든다.
 * 정점이 5인 경우
 * 1 = 2-3-4
 * 2 = 1-3 
 * 3 = 4
 * 4 = 2-5
 * 5
 */
