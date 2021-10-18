import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < N; i++){
            if(check(br))
                count++;
        }
        System.out.println(count);

    }
    public static boolean check(BufferedReader br) throws IOException {
        boolean[] check = new boolean[26];
        int prev = 0;
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            int now = str.charAt(i); // i 번째 문자 저장 (현재 문자)

            //앞선 문자와 i번째 문자가 같지 않다면?
            if(prev != now){
                //해당 문자가 처음 나오는 경우(false)
                if(!check[now - 'a']){
                    check[now - 'a'] = true;
                    prev = now;
                }
                //해당 문자가 이미 나온 적이 있는 경우 (그룹단어 x)
                else{
                    return false;
                }
            }
            //앞선 문자와 i번째 문자가 같다면? (연속된 문자)
            else{
                continue;
            }
        }
        return true;
    }
}
