import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<String> solution(String[] str){
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = new String[N];

        for(int i=0; i<N; i++){
            str[i] = sc.next();
        }

        for(String s : T.solution(str)){
            System.out.println(s);
        }
    }
}






import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<String> solution(String[] str){
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str){
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length() - 1;
            
            while(lt < rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = new String[N];

        for(int i=0; i<N; i++){
            str[i] = sc.next();
        }

        for(String s : T.solution(str)){
            System.out.println(s);
        }
    }
}
