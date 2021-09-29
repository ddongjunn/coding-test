import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        StringTokenizer st = new StringTokenizer(num," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> name = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        int val = 1;
        for(int i = 0; i < N + M; i++) {
            String key = br.readLine();
            if (name.containsKey(key)) {
                list.add(key);
            } else {
                name.put(key, val);
            }
            val = 1;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(String str : list){
            System.out.println(str);
        }
    }
}