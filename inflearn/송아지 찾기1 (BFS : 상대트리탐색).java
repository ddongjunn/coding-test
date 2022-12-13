import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    int[] distance = {1, -1, 5};
    int[] chk;
    Queue<Integer> q = new LinkedList<>();

    public int BFS(int s, int e){
        chk = new int[10001];
        chk[s] = 1; //출발지점
        q.offer(s); 
        int level = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                int x = q.poll();
                for(int j=0; j<distance.length; j++){
                    int nx=x+distance[j];
                    if(nx == e) return level+1;
                    if(nx >= 1 && nx <= 10000 && chk[nx] == 0){//방문한 지점인지 체크
                        chk[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            level++;
        }
        return 0;
    }
    
    public static void main(String[] args) {
       Main main = new Main();
       Scanner scan = new Scanner(System.in);
       int s = scan.nextInt();
       int e = scan.nextInt();
       System.out.println(main.BFS(s, e));
    }
}


