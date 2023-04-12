import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        dist[N] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<3; i++){
                int next;
                if(i == 0){
                    next = cur + 1;
                }else if(i == 1){
                    next = cur - 1;
                }else{
                    next = cur * 2;
                } 

                if(next >= 0 && next < dist.length && dist[next] == -1){
                    q.add(next);
                    dist[next] = dist[cur] + 1;
                }

                if(next == K){
                    System.out.println(dist[K]);
                    return;
                }
            }
        }
    }
}
