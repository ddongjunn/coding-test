import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void solution(ArrayStack stack, String[] str){
        switch(str[0]){
            case "push":
                stack.push(Integer.parseInt(str[1]));
                break; 

            case "top":
                stack.top();
                break;

            case "size":
                stack.size();
                break;

            case "empty":
                stack.empty();
                break;

            case "pop":
                stack.pop();
                break;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayStack stack = new ArrayStack(N);

        for(int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            solution(stack, str);
        }
        
    }
}

class ArrayStack{
    int top;
    int size;
    int[] stack;

    public ArrayStack(int size){
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int item){
        stack[++top] = item;
    }

    public void pop(){
        if(top == -1){
            System.out.println(-1);
        }else{
            int item = stack[top];
            stack[top--] = 0;
            System.out.println(item);
        }
    }

    public void size(){
        System.out.println(top+1);
    }

    public void empty(){
        if(top == -1) System.out.println(1);
        else System.out.println(0);
    }

    public void top(){
        if(top == -1){
            System.out.println(-1);
        }else{
            int item = stack[top];
            System.out.println(item);
        }
    }
}
