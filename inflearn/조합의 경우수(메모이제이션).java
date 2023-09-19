import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[][] arr = new int[35][35];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        System.out.println(dfs(n, r));
    }

    private static int dfs(int n, int r) {
        if(arr[n][r] > 0){
            return arr[n][r];
        }

        if(r == 0 || n == r){
            return 1;
        }else{
            return arr[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
        }
    }
}

/*
 * 
 *           5C3
 *      4C2   +   4C3
 *   3C1 + 3C2  3C2 + 3C3
 * 
 * {1, 2, 3, 4, 5}
 * 5C3 5명중 3명을 뽑는 방법은 2가지로 나눠진다.
 * 
 * 4C2
 * 5번학생이 참가해서 3명이 만들어졌거나, 
 * {1, 2, 5}
 * {1, 3, 5}
 * 
 * 4C3
 * 참가하지 않고 만들어졌거나
 * {1, 2, 3}
 * {2, 3, 4}
 * 
 * 
 * 
 * r = 0 || n == r
 */
