import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Main{
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=1; i<=N; i++){
            list.add(i);
        }

        StringBuffer sb = new StringBuffer();
        sb.append('<');
    
        int idx = 0; //리스트에서 삭제할 요소를 참조할 인덱스 변수
        while(list.size() > 1){
            idx = (idx + (K - 1)) % list.size(); 
            sb.append(list.remove(idx)).append(", ");
        }
        sb.append(list.remove()).append('>');
        
        System.out.println(sb.toString());
    }
}
