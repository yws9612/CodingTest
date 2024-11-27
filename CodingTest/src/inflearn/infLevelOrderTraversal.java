package inflearn;

import java.util.LinkedList;
import java.util.Queue;

public class infLevelOrderTraversal {

    infNode root;

    public static void main(String[] args) {
        /*
        트리를 활용한 코테 문제
        트리
            1) 트리 구현
            2) 트리 순회
                2-1) level order *
                2-2) post order *
                2-3) pre order
                2-4) inner order

         트리에서 문제 이해하기
            input, output 확인
            input size N 확인
            제약조건 확인
            예상할 수 있는 오류 파악

         Maximum Depth of Binary Tree
         문제에서 binary tree 하나가 주어진다. 주어진 binary tree의 최대 깊이를 반환해라.

         트리는 bfs, dfs개념이 없음. 해당 개념은 그래프에서 적용됨.
         levelorder == bfs
         post/pre/inner order == dfs
         */

        infLevelOrderTraversal tree = new infLevelOrderTraversal();

        tree.root = new infNode(3);
        tree.root.lc = new infNode(5);
        tree.root.rc = new infNode(1);
        tree.root.lc.lc = new infNode(6);
        tree.root.lc.rc = new infNode(2);
        tree.root.lc.rc.lc = new infNode(7);
        tree.root.lc.rc.rc = new infNode(4);
        tree.root.rc.lc = new infNode(0);
        tree.root.rc.rc = new infNode(8);

        //LevelOrder(bfs) 실행
        tree.bfs(tree.root);

        //PostOrder(dfs) 실행
        int val = tree.dfs(tree.root);
        System.out.println(val);
    }

    public void bfs(infNode node){
        int l = 0;

        if(node == null){
            System.out.println(0);
            return;
        }
        Queue<infNode> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){ //레벨 별, depth별 작업이 없으면 for문은 필요 없음.
                infNode curNode = q.poll();
                if(curNode.lc != null){
                    q.offer(curNode.lc);
                }
                if(curNode.rc != null){
                    q.offer(curNode.rc);
                }
            }
            l++;
        }
        System.out.println(l);
    }

    public int dfs(infNode node){
        int max = 0;

        if(node == null){
            return 0;
        }else{
            int l = dfs(node.lc);
            int r = dfs(node.rc);
            max = Math.max(l,r) + 1;
            return max;
        }
    }
}
