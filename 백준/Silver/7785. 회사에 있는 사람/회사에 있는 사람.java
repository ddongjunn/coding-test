import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Set<String> log = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String action = input[1];

            if ("enter".equals(action)) {
               log.add(name);
            } else {
               log.remove(name);
            }
        }

        log.forEach(System.out::println);
    }
}