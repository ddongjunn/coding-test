import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int w, L;
    static Queue<Integer> truck = new LinkedList<>();
    static Queue<Integer> bridge = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < w; i++){
            bridge.offer(0);
        }

        int ans = 0;
        int bw = 0;
        while(!bridge.isEmpty()){
            ans++;
            bw -= bridge.poll();
            if(!truck.isEmpty()){
                if(truck.peek() + bw <= L){
                    bw += truck.peek();
                    bridge.offer(truck.poll());
                }else{
                    bridge.offer(0);
                }
            }
        }
        System.out.println(ans);
    }
}