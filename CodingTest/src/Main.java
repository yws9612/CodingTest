import java.util.LinkedList;
import java.util.Queue;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    Node root;

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(0);
        tree.root.lt = new Node(1);
        tree.root.rt = new Node(2);
        tree.root.lt.lt = new Node(3);
        tree.root.lt.rt = new Node(4);
        tree.root.rt.lt = new Node(5);
        tree.root.rt.rt = new Node(6);

        tree.BFS(tree.root);
    }

    //DFS
    private void DFS(Node root) {
        if(root == null){
            return;
        }else{
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);
        }
    }

    //BFS
    private void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; ++i) {
                Node current = Q.poll();
                System.out.print(current.data + " ");
                if(current.lt != null) {
                    Q.offer(current.lt);
                }
                if(current.rt != null) {
                    Q.offer(current.rt);
                }
            }
            L++;
            System.out.println();
        }
    }
}


class Node {
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt = null;
        rt = null;
    }
}