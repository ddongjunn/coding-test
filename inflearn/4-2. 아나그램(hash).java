import java.util.*;

public class Main {
    static String solution(String str1, String str2){
        String answer = "YES";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<str1.length(); i++){
            map1.put(str1.charAt(i),map1.getOrDefault(str1.charAt(i),0)+1);
            map2.put(str2.charAt(i),map2.getOrDefault(str2.charAt(i),0)+1);
        }
        
        for(char key : map1.keySet()){
            if(!map2.containsKey(key) || (map1.get(key) != map2.get(key)) ) return "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        System.out.println(solution(str1, str2));
    }
}

/*
해설
핵심은 문자열의 길이가 같다.
abaCC일 경우 a=2 b=1 C=2로 가정하여, 2번째 문자열에서 1번째 문자열의 key일 경우 하나씩 감소한다.
Caaab

    static String solution(String str1, String str2){
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        //str1 먼저 map에 세팅
        for(char x : str1.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        //map에 존재하는지 확인
        for(char x : str2.toCharArray()){
            if(!map.containsKey(x) || map.get(x) == 0) return "NO"; //map에 key가 존재하지않거나, 중간에 value가 0일 경우 return
            map.put(x, map.get(x)-1);
        }

        return answer;
    }

 */
