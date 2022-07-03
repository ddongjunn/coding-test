import java.util.Scanner;

public class Main {
    public String solution(String str){
        String strUpper = str.toUpperCase();
        String tmp = "";

        for(int i=strUpper.length(); i>0; i--){
            tmp += strUpper.charAt(i-1);
        }

        if(tmp.equals(str.toUpperCase())){
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(main.solution(str));
    }
}


///////////////////////////////////////////////////////

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();
        
        for(int i=0; i<len/2; i++){
            if(str.charAt(i) != str.charAt(len-i-1)){
                return "NO";
            }
        }

        return answer;
    }
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(main.solution(str));
    }
}


///////////////////////////////////////////////////////

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer = "YES";
        String tmp = new StringBuilder(str).reverse().toString();

        if(!str.equalsIgnoreCase(tmp)){
            answer="NO";
        }

        return answer;
    }
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(main.solution(str));
    }
}

