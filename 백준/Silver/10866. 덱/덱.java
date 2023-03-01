import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<N; i++){

            String[] cmd = br.readLine().split(" ");
        
            switch(cmd[0]){
                case "push_front":
                    deque.offerFirst(Integer.parseInt(cmd[1]));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(cmd[1]));
                    break;
                case "pop_front":
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(deque.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(deque.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        sb.append("1").append("\n");
                    }else{
                        sb.append("0").append("\n");
                    }
                    break;
                case "front":
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(deque.getFirst()).append("\n");
                    break;
                case "back":
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(deque.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
