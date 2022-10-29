import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static void solution(int[] arrX, int[] arrY){
        int[] sumArr = IntStream.concat(IntStream.of(arrX),IntStream.of(arrY)).sorted().toArray();
        for (int i : sumArr) {
            System.out.print(i + " ");
        }
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

        solution(arrX, arrY);
    }
}


/*
* 강사님 풀이 
* (two pointers algorithm)
*/

package hello.core.order;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> solution(int x, int[] arrX, int y, int[] arrY){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int p1 = 0;
        int p2 = 0;
        while(p1<x && p2<y){
            if(arrX[p1] < arrY[p2]){
                answer.add(arrX[p1++]); //후위증감연산자사용 arrX[p1] add가 되고, p1의 값이 증가
            }else{
                answer.add(arrY[p2++]);
            }
        }
        //둘중 남아있는 배열의 값 넣어주기
        while(p1<x) answer.add(arrX[p1++]);
        while(p2<y) answer.add(arrY[p2++]);

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



