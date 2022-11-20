import java.util.Scanner;

public class Main{
    public static void solution(int N, int[] arr){
        int tmp = 0;
        int idx = 0;
        for(int i=0; i<N-1; i++){   //첫번째 위치(index)
            idx = i;
            for(int j=i+1; j<N; j++){   //i+1번째 원소부터 선택한 위치(index)의 값과 비교
                if(arr[j]<arr[idx]){    //오름차순이므로 현재 선택한 자리에 있는 값보다 값이 작다면, 위치(index)를 갱신
                    idx = j;
                }
            }   
            tmp = arr[idx]; //2번째 반복이 끝난 후 위치(i)와 위치(index)를 swap
            arr[idx] = arr[i];
            arr[i] = tmp;
        }

        for(int i : arr){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scan.nextInt();
        }
        solution(N, arr);
    }
}

/*
선택정렬(Selection Sort) - 배열에서 해당 idx를 선택하고, 그 idx에 오는 값을 찾는 것
1. 주어진 배열 중에 최소값을 찾는다.
2. 그 값을 맨 앞에 위차한 값과 교체(swap)
3. 맨 처음 위치를 뺀 나머지 배열을 같은 방법으로 교체(1~2 반복)

 *  arr 
 *  13 5 11 7 23 15
 *  
 *  idx = i
 *  for(j=i+1; j<N; j++)
 *      if(arr[j] < arr[idx])
 *          idx = j
 *          swap(arr[i], arr[idx])
 */
