import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point>{
    public int x;
    public int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /* 음수를 return
     * 순서는 앞:this, 뒤:o
     * 
     * 오름차순
     * this.y - o.y
     * this.x - o.x
     * 
     * 
     * 내림차순은? this가 크고 object가 작은경우
     * o.y - this.y
     * o.x - this.x
     * 
     */
    @Override
    public int compareTo(Point o) { //오름차순은 음수값을 return, 순서는 
        if(this.x == o.x) return this.y - o.y; 
        else return this.x - o.x;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<N; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            arr.add(new Point(x,y));
        }

        Collections.sort(arr);
        for(Point o : arr){
            System.out.println(o.x + " " + o.y);
        }
    }
}
