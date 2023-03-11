import java.util.Scanner;

public class Main {
	static String answer = "NO";
	static int n, total = 0;
	static boolean flag = false;
	public static void DFS(int L, int sum, int[] arr){
		if(flag || sum > total / 2){
			return;
		}
		
		if(L==n){
			if((total - sum) == sum){ //2개의 부분집합의 합이 같을때
				answer = "YES";
				flag = true;
			}
		}else{
			DFS(L+1, sum+arr[L], arr); //포함하는 부분집함
			DFS(L+1, sum, arr); //포함하지 않는 부분집합
		}
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = scan.nextInt();
			total += arr[i];
		}		
		DFS(0, 0, arr);
		System.out.println(answer);
	}
}
