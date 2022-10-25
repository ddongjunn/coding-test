package hello.core;

import java.util.Scanner;

public class Main {
    public int solution(int n, int[][]arr){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int answer = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                boolean flag = true;    //봉우리 판별
                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n){ //격자의 가장자리 조건
                        if(arr[nx][ny] >= arr[i][j]){
                            flag = false;
                            break;  //4방향 전부 확인할 필요 없음
                        }
                    }
                }
                if(flag) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n+1][n+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=scan.nextInt();
            }
        }

        System.out.println(main.solution(n, arr));
    }
}
