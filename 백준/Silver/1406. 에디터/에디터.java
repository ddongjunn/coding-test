import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main{
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<Character>();
    
        for(int i=0; i<str.length(); i++){
            list.add(str.charAt(i));
        }

        ListIterator<Character> iterator = list.listIterator();
        //커서 초기화 : 맨 뒤
		while(iterator.hasNext()) {
			iterator.next();
		}

        for(int i=0; i<N; i++){
            String command = br.readLine();
            char ch = command.charAt(0);

            switch (ch) {
                case 'L':
                    if(iterator.hasPrevious()) 
                        iterator.previous();
                    break;
                case 'D':
                    if(iterator.hasNext()) 
                        iterator.next();
                    break;
                case 'B':
                    if(iterator.hasPrevious()){
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P':
                    iterator.add(command.charAt(2));
                    break;
                default:
                    break;
            }
        }

        for(Character ch : list){
            bw.write(ch);
        }

        bw.flush();
        bw.close();
    }
}
