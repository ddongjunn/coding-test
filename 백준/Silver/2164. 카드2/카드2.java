import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) queue.add(i);

        while(queue.size() != 1){
            queue.pollFirst();
            queue.add(queue.pollFirst());
        }
        System.out.println(queue.get(0));
    }
}
