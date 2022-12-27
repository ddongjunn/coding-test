import java.util.Scanner;

public class Main{
    
    public static void solution(String num){
        int[] nums = new int[10];
        int max = Integer.MIN_VALUE;

        for(char ch : num.toCharArray()){
            nums[ch - '0']++;
        }

        int k = nums[6] + nums[9]; //6, 9는 혼합하여 사용가능
        if(k % 2 == 0){//6 + 9의 갯수가 짝수일 경우 
            nums[6] = k / 2;
            nums[9] = k / 2;
        }else{
            nums[6] = (k / 2) + 1;
            nums[9] = (k / 2) + 1;
        }

        for(int i : nums) max = Math.max(max,i);
        System.out.println(max);
    }

    /*
     * for(char ch : N.toCharArray()) {
			int num = ch - '0';
			if(num==9) { 
				num = 6;
			}
			nums[num]++;
		}
        
		// 6과 9는 바꿀 수 있으므로 2로 나눔
		nums[6] = nums[6]/2 + nums[6]%2;
		
		Arrays.sort(nums); 
		// 오름차순 정렬이므로 마지막 요소 출력
        
		System.out.println(nums[9]);
     * 
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String num = scan.next();
        solution(num);
        scan.close();
    }
}
