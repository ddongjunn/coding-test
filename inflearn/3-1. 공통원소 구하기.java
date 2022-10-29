import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> solution(int x, int[] arrX, int y, int[] arrY){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(arrX);
        Arrays.sort(arrY);

        int p1 = 0;
        int p2 = 0;
        while(p1<x && p2<y) { //둘중 하나의 조건이라도 다르면 중복된 값이 없다.
            if (arrX[p1] < arrY[p2]) { //작은값의 배열 index 증가
                p1++;
            } else if (arrX[p1] > arrY[p2]) {
                p2++;
            } else { //arrX[p1] == arrY[p2]일 경우 p1, p2 증가
                answer.add(arrX[p1]);
                p1++;
                p2++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int arrX[] = new int[x];
        for(int i=0; i<x; i++){
            arrX[i] = scan.nextInt();
        }

        int y = scan.nextInt();
        int arrY[] = new int[y];
        for(int i=0; i<y; i++){
            arrY[i] = scan.nextInt();
        }

        for(int num : solution(x, arrX, y, arrY)){
            System.out.print(num + " ");
        }
    }
}
