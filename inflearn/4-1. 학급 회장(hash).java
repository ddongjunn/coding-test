import java.util.*;

public class Main {
    static char solution(int n, String str){
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : str.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);  //getOrDefault() x라는 key가 없으면 default = 0
        }

        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = scan.next();
        System.out.println(solution(n, s));

    }
}

/*
    
    map.getOrDefault() - map count시 자주 사용하는 함수
    map.containsKey(key) - key 유무확인
    map.size() - 키 갯수
    map.remove(key) - key 삭제 
 */
