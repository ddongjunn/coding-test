public class Main{
    static int n;
    static int[] chk;

    public void DFS(int level){
        if(level == n+1){
            String tmp = "";
            for(int i=1; i<=n; i++){
                if(chk[i]==1){
                    tmp+=(i+" ");
                }
            }
            if(tmp.length()>0){
                System.out.println(tmp);
            } 
        }else{
            chk[level] = 1; //왼쪽 (사용함)
            DFS(level+1); 
            chk[level] = 0; //오른쪽 (사용안함)
            DFS(level+1);
        }
    }
    
    public static void main(String[] args) {
       Main main = new Main();
       n = 3;
       chk=new int[n+1]; //index 0은 사용안함, 사용하는 수인지, 사용안하는 수인지 판별하는 배열
       main.DFS(1);
    }
}


