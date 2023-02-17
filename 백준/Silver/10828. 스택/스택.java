import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayStack stack = new ArrayStack(N);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            
            switch(str[0]){
                case "push":
                    stack.push(Integer.parseInt(str[1]));
                    break; 
    
                case "top":
                    sb.append(stack.top()).append('\n');
                    break;
    
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
    
                case "empty":
                    sb.append(stack.empty()).append('\n');
                    break;
    
                case "pop":
                    sb.append(stack.pop()).append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());
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

    public int pop(){
        if(top == -1) return -1;

        int item = stack[top];
        stack[top--] = 0;
        return item;
    }

    public int size(){
        return top+1;
    }

    public int empty(){
        if(top == -1) return 1;
        return 0;
    }

    public int top(){
        if(top == -1) return -1;
        return stack[top];
    }
}