import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int f, s, g, u, d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        f = Integer.parseInt(st.nextToken()); //전체 층 높이
        s = Integer.parseInt(st.nextToken()); //현재 층
        g = Integer.parseInt(st.nextToken()); //목표 층
        u = Integer.parseInt(st.nextToken()); //up
        d = Integer.parseInt(st.nextToken()); //down
        
        int[] dist = new int[f+1];
        Arrays.fill(dist, -1);
        dist[s] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        int[] dir = {u, -d};
        while(!q.isEmpty()){
            int cur = q.poll();
            for (int i : dir) {
                int next = cur + i;
                if(!isInRange(next)){
                    continue;
                }
                if(dist[next] != -1){
                    continue;
                }
                q.add(next);
                dist[next] = dist[cur] + 1; 
            }
        }

        if (dist[g] == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(dist[g]);
        }
    }

    static boolean isInRange(int pos){
        return pos <= f && pos >= 1;
    }
}