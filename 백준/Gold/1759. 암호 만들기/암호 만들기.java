import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
    static int L, C;
    static char in[], out[];
    static Set<Character> vowels;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        in = new char[C];
        out = new char[L];
        st = new StringTokenizer(br.readLine());

        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for(int i=0; i<C; i++){
            in[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(in);
        func(0, 0);
        System.out.println(sb.toString());
    }

    public static void func(int start, int depth){
        if(depth == L){
        
            int cntVowel = 0;
            int cntConsonants = 0;
            for(char ch : out){
                if(vowels.contains(ch)){
                    cntVowel++;
                }else{
                    cntConsonants++;
                }
            }   

            if(cntVowel >= 1 && cntConsonants >= 2){
                for(char ch : out){
                    sb.append(ch);
                }
            sb.append("\n");
            }
            return;
        }

        for(int i=start; i<C; i++){
            out[depth] = in[i];
            func(i + 1, depth + 1);
        }
    }
}