import java.util.Scanner;

public class Main{
    public static int count(int[] arr, int capacity){
        int cnt = 1;
        int sum = 0;
        for(int x : arr){
            if(sum+x > capacity){
                cnt++;
                sum=x;
            }else{
                sum += x;
            } 
        }
        return cnt;
    }
    public static int solution(int n, int m, int[] arr){
        int answer = 0;

        //int lt = Arrays.stream(arr).max().getAsInt();
        //int rt = Arrays.stream(arr).sum();
        int lt = arr[n-1];
        int rt = 0;
        for(int i : arr) rt += i;
        
        while(lt <= rt){ 
            int mid = (lt+rt)/2;
            if(count(arr, mid) <= m){ //m보다 작을경우엔 무조건 가능하다.
                answer = mid;
                rt = mid - 1;
            }else{
                lt = mid + 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}

/*
 * 결정 알고리즘
 *  - 이분검색을 이용 (정렬된 숫자)
 *  - lt 혹은 rt 가 답으로써 가능한 숫자인지를 판별
 *    최소 용량 크기인 경우 좁혀나가면 된다.
 * 
 * 문제에서는 DVD의 최소 용량 크기를 구해야한다.
 * lt부터 rt사이에 DVD의 최소 용량 크기가 분명히 있다.
 * 이럴때 결정 알고리즘을 사용하면 된다.
 * 
 * lt = 9 -> 최소 : 용량은 9가 되어야한다. (곡의 길이가 제일 긴게 9이기 떄문에)
 * rt = 45 -> 최대 : 모든 곡의 길이를 더한 숫자 (최대숫자를 넘어갈 필요가 없다.)
 * mid = 27 -> 3장에 다 담을 수 있는지 검증
 * 
 * answer = 27 (조건 만족하기 때문에)             
 * 조건을 만족하면 최소 용량이기 때문에 mid ~ rt는 삭제
 * 
 * rt = 26
 * mid = (9+26)/2
 * mid = 17 -> 3장에 다 담을 수 있는지 검증
 * 검증된 경우 answer = 17
 * 
 * 
 * rt = 16
 * lt = 9
 * mid = 12 -> 3장에 다 담을 수 있는지 검증 
 * 검증이 안된 경우 
 * lt = 13
 * rt = 16
 * 이분검색 쭉 진행..
 * 
 * lt <= rt 멈추는 조건
 * 
 */
