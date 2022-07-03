import java.util.Scanner;

public class Main {
    public int solution(String str){
        int answer;
        str = str.toUpperCase().replaceAll("[^0-9]","");
        answer = Integer.parseInt(str);
        return answer;
    }
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(main.solution(str));
    }
}


//////////////////////////////////////////////////


import java.util.Scanner;

public class Main {
    public int solution(String str){
        int answer = 0;
        for(char ch : str.toCharArray()){
            if(48 <= ch && ch <= 57){
                answer = answer * 10 + (ch - 48);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(main.solution(str));
    }
}
