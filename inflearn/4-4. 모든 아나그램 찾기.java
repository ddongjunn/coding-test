import java.util.HashMap;
import java.util.Scanner;

public class Main{
    static int solution(String s, String t){
        int answer = 0;
        int lt = 0;
        char[] ch = s.toCharArray();

        /*
        String str = "abc";
        t문자열 sm에 초기화 (비교할 map)
        a:1, b:1, c:1
         */
        HashMap<Character, Integer> sm = new HashMap<>();
        for(char c : t.toCharArray()) sm.put(c,sm.getOrDefault(c,0)+1);

        /*
        String str = "abc";
        t문자열의 길이 - 1 까지 초기화
        a:1, b:1
         */
        int L = t.length() - 1;
        HashMap<Character, Integer> tm = new HashMap<>();
        for(int i=0; i<L; i++) tm.put(ch[i], tm.getOrDefault(ch[i],0)+1);

        /*
        
         */
        for(int rt=L; rt<ch.length; rt++){
            tm.put(ch[rt], tm.getOrDefault(ch[rt],0)+1);
            if(tm.equals(sm)) answer++;
            tm.put(ch[lt],tm.get(ch[lt])-1);
            if(tm.get(ch[lt]) == 0) tm.remove(ch[lt]);
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String t = scan.next();
        System.out.println(solution(s,t));
    }
}
/*
t문자열을 sm에 초기화 -> a:1, b:1, c:1
t길이 - 1 까지 tm에 미리 세팅 -> a:1, b:1

for문 : rt는 t길이 -1 부터 시작 -> arr[rt]를 map에 세팅
        sm, tm를 비교 (equals) -> 같으면 answer++
        tm에서 ch[lt]의 값을 제거 (여기서는 이미 입력된 키값이기 때문에 뺄셈만해줘도된다.)
        tm.get(ch[lt]) == 0 일 경우에 key 제거
        lt++
 */
