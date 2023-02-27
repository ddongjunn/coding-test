import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            switch(command){
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(queue.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    } 
                    sb.append(queue.pollFirst()).append("\n");
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    if(queue.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;

                case "front":
                    if(queue.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(queue.getFirst()).append("\n");
                    break;

                case "back":
                    if(queue.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(queue.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
