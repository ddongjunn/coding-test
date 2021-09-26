public class Main {
    public static void main(String[] args) {

        boolean[] check = new boolean[10001]; //1부터 10000

        Test test = new Test();

        for(int i = 1; i < 10001; i++){
            int n = test.d(i);

            if(n < 10001){
                check[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < check.length; i++){
            if(!check[i]){ //false만 출력
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}

class Test{
    public int d(int n){
        int sum = n;

        while(n != 0){
            sum = sum + (n % 10);
            n = n / 10;
        }

        return sum;
    }
}
