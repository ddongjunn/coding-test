import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        this.data = val;
        lt = null;
        rt = null;
    }
}
public class Main{
    Node root;
    public static int DFS(Node root){ //root는 node를 가르킨다.
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        int level = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                Node cur = q.poll();
                if(cur.lt == null && cur.rt == null) return level;
                if(cur.lt != null) q.offer(cur.lt);
                if(cur.rt != null) q.offer(cur.rt);
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
      Main tree = new Main();
      tree.root = new Node(1);
      tree.root.lt = new Node(2);
      tree.root.rt = new Node(3);
      tree.root.lt.lt = new Node(4);
      tree.root.lt.rt = new Node(5);
      System.out.println(tree.DFS(tree.root));
    }
}
