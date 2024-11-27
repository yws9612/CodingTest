package inflearn;

import java.util.LinkedList;
import java.util.Queue;

public class infTraversal {
    public static void main(String[] args) {
        /*
        트리 순회 : 트리 탐색이라고도 불리우며, 트리의 각 노드를 방문하는 과정을 말함.
        모든 노드를 한 번씩 방문해야 하므로 완전 탐색이라고도 불림.
        순회 방법으로는 너비 우선 탐색의 BFS와 깊이 우선 탐색의 DFS가 있음.
         */

    }

    //BFS는 레벨 별 탐색
    public LinkedList bfs(infNode node){
        LinkedList<Integer> visited = new LinkedList<>();
        if (node == null){
            return visited;
        }
        Queue<infNode> q = new LinkedList<>();
        q.offer(node);
        //함수 선언구부터 해당 주석까지는 외울 것
        while(!q.isEmpty()){
            infNode c_Node = q.poll();
            //출력 필요 시 System.out.print(c_Node.value + " "); 추가
            visited.add(c_Node.value);

            if(c_Node.lc != null){
                q.add(c_Node.lc);
            }

            if(c_Node.rc != null){
                q.add(c_Node.rc);
            }
        }
        return visited;
    }

    //DFS는 Height 우선 순위로 탐색. 스택, 재귀함수로 구현 가능하며 보통 재귀함수를 사용하여 구현
    public void dfs (infNode node){
        if (node == null){ //재귀 BaseCase
            return;
        }else{
            //데이터 출력이 필요하면 System.out.println(node.value + " "); 추가
            dfs(node.lc);
            dfs(node.rc);
        }
    }

}
