import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static int count(int[] arr, int dist){
        int cnt = 1; //한마리 배치했다고 가정 
        int ep = arr[0]; //제일 왼쪽에!!
        for(int i=1; i<arr.length; i++){
            if(arr[i]-ep >= dist){
                ep = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
    
    public static int solution(int n, int c, int[] arr){
        int answer = 0;

        Arrays.sort(arr);
        int lt = 1; //두 말 사이의 최솟값
        int rt = arr[n-1];

        while(lt <= rt){
            int mid = (lt + rt)/2;
            if(count(arr, mid) >= c){//유효함수, return된 말의 마릿수가 c 이상이면 유효
                answer = mid;
                lt = mid + 1;//최댓값을 찾아야함. (mid값 보다 더 큰 값이 있는지)
            }else{
                rt = mid - 1;//거리가 넓어서 배치가 불가능한 경우
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        System.out.println(solution(n, c, arr));
    }
}

/*
 * N개의 마구간이 수직선상에 있다. (마구간간에 좌표가 중복되는 일은 없음)
 * 현수는 C마리의 말을 가지고 있고, 이 말들은 서로 가까이 있는 것을 좋아하지 않는다.
 * 각 마구간에는 한 마리의 말만 넣을 수 있다.
 * 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고싶다.
 * C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력
 * 
 * 
 * lt = 1, 두 말 사이의 최솟값
 * rt = 배열의 최댓값
 * 5 3
 * 1 2 8 4 9
 * 
 * mid = 5 -> 가장 가까운 두 말의 거리가 5였을때 3마리를 배치해서 유효한지 검증
 * 
 * 
 * 검증 ep = 1
 * arr[i] - ep >= mid 조건 성립시 두번째 말 배치, ep = 8
 * 말의 마릿수 count 하여 return시 count값과 mid 값이 다른 경우 배치 불가능
 *     ㄴ rt = 4, mid = 2, 유효 answer = 2
 * 
 * 
 * lt = mid + 1 (3)
 * mid = 3 + 4 / 2 = 3
 * mid가 3일경우도 유효, answer = 3      
 * 
 */
