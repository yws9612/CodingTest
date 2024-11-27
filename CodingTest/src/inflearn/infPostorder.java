package inflearn;

public class infPostorder {

    infNode root;

    public static void main(String[] args) {
        /*
        Binary 트리에서 Lowest Common Ancestor(두 노드의 공통 조상 중 가장 낮은 node)를 찾는 문제

        문제에서 Binary 트리 하나와 해당 트리에 속한 두개의 노드가 주어진다. 이 때, 두 노드의
        공통 조상 중 가장 낮은 node 즉, the lowes common ancestor(LCA)를 찾아라.
         */
        infPostorder tree = new infPostorder();
        tree.root = new infNode(3);
        tree.root.lc = new infNode(5);
        tree.root.rc = new infNode(1);
        tree.root.lc.lc = new infNode(6);
        tree.root.lc.rc = new infNode(2);
        tree.root.lc.rc.lc = new infNode(7);
        tree.root.lc.rc.rc = new infNode(4);
        tree.root.rc.lc = new infNode(0);
        tree.root.rc.rc = new infNode(8);

        infPostorder result = new infPostorder();
        
        System.out.println(result.dfs(tree.root, 6, 4).value);
    }

    public infNode dfs(infNode node, int p, int q){
        if(node == null){
            return null;
        }else{
             infNode left = dfs(node.lc, p, q);
             infNode right = dfs(node.rc, p, q);

             if(node.value == p || node.value == q){
                 return node;
             }else if(left != null && right != null){
                 return node;
             }else{
                 return (left != null) ? left : right;
             }

        }
    }

}
