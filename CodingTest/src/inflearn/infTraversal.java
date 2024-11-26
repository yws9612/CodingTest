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

    public LinkedList BFS(infNode Node){
        LinkedList<Integer> visited = new LinkedList<>();
        if (Node == null){
            return visited;
        }
        Queue<infNode> q = new LinkedList<>();
        q.offer(Node);
        //함수 선언구부터 해당 주석까지는 외울 것
        while(q.isEmpty()){
            infNode c_Node = q.poll();
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
}
