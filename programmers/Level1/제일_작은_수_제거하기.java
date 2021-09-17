class Solution {
    public int[] solution(int[] arr) {              
        int[] answer = new int[arr.length-1];
        if(answer.length == 0 ){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        int temp = arr[0];
        for(int i=1; i<arr.length; i++){
            if(temp > arr[i]){
                temp = arr[i];
            }
        }

        int index = 0;
        for(int i=0; i<arr.length; i++){
            if(temp < arr[i]){
                answer[index] = arr[i];
                index++;
            }
        }
        System.out.println(temp);
        return answer;
    }
}