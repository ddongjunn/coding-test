import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer = "";
        int max = Integer.MIN_VALUE;
        String[] word = str.split(" ");
        for(String s : word){
            int len = s.length();
            if(len > max){
                max = len;
                answer = s;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}


public class Main {
    public String solution(String str){
        String answer = "";
        int max = Integer.MIN_VALUE;
        int pos;

        while((pos = str.indexOf(" ")) != -1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(max < len){
                max = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }

        if(str.length() > max){
            answer = str;
        }

        return answer;
    }
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}
