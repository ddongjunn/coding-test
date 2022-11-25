import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static ArrayList<Integer> solution(int N, int[] H){
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = H.clone(); //입력받은 배열 깊은복사
        Arrays.sort(tmp); //오름차순
        for(int i=0; i<N; i++){ //해당index값이 다르면 index값(+1) 추가
            if(H[i] != tmp[i]) answer.add(i+1);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] H = new int[N];
        for(int i=0; i<N; i++) H[i] = scan.nextInt();
        for(int i : solution(N,H)) System.out.print(i + " ");
    }
}
