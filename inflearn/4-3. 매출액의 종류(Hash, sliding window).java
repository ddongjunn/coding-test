import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main{
    static ArrayList<Integer> solution(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        //미리 k-1일 까지 세팅
        for(int i=0; i<k-1; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        int lt = 0;
        for(int rt=k-1; rt<n; rt++){
            map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);
            answer.add(map.size());//매출액의 종류
            map.put(arr[lt], map.get(arr[lt])-1);//오른쪽으로 밀기
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]); //lt값이 없으면 (=0이면) 키 삭제
            lt++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        for(int x : solution(n, k, arr)) System.out.print(x + " ");
    }
}
