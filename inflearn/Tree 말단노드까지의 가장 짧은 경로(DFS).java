
/*
 * 최단 경로 문제, BFS로 푸는게 맞는 문제!
 * 
 * DFS학습겸 풀이!
 * DFS로 풀 경우 자식 lt, rt가 전부 존재해야한다.
 */
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
    public static int DFS(int level, Node root){ //root는 node를 가르킨다.
            if(root.lt == null && root.rt == null){
                return level;
            }else{
                return Math.min(DFS(level+1, root.lt), DFS(level+1, root.rt));
            }
    }

    public static void main(String[] args) {
      Main tree = new Main();
      tree.root = new Node(1);
      tree.root.lt = new Node(2);
      tree.root.rt = new Node(3);
      tree.root.lt.lt = new Node(4);
      tree.root.lt.rt = new Node(5);
      System.out.println(tree.DFS(0, tree.root));
    }
}
