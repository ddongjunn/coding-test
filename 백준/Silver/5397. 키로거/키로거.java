import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    
    public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String command;

        for(int i=0; i<N; i++){
            command = br.readLine();
            sb.append(findPasswd(command)).append('\n');
        }

        System.out.println(sb.toString());
    }

    public static String findPasswd(String command){
        StringBuilder sb = new StringBuilder();
        Stack<Character> preStack = new Stack<>();
        Stack<Character> postStack = new Stack<>();
        
        for(int i=0; i<command.length(); i++){
            char ch = command.charAt(i);
            switch(ch){
                case '<':
                    if(!preStack.isEmpty())
                        postStack.push(preStack.pop());
                    break;
                case '>':
                    if(!postStack.isEmpty())
                        preStack.push(postStack.pop());
                    break;
                case '-':
                    if(!preStack.isEmpty())
                        preStack.pop();
                    break;
                default:
                    preStack.push(ch);
                    break;
            }
        }

        while(!postStack.isEmpty())
            preStack.push(postStack.pop());

        for(int i=0; i<preStack.size(); i++){
            sb.append(preStack.elementAt(i));
        }
        
        return sb.toString();
    }
}
