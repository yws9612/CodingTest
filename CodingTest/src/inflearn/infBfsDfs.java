package inflearn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class infBfsDfs {

    static int[][] room = {
            {1, 3},
            {2, 4},
            {0},
            {4},
            {},
            {3, 4}
    };

    static HashSet<Integer> visited = new HashSet<>();
    static boolean [] bVisited;


    public static void main(String[] args) {
        /*
        그래프 구현
        그래프 치환 방법 및 BFS, DFS 구현 진행

        시간복잡도는 10^8 기준으로 생각할 것

        Keys and Rooms
        0번방부터 n-1번방까지 총 n개의 방이 있다. 0번방을 제외한 모든 방음 잠겨있다. 우리의 목표는 모든 방에 visit하는 것이다.
        하지만 잠겨져있는 방은 key가 없으면 visit할 수 없다. 각 방에 방문할 때, 별개의 열쇠뭉치(a set of distinct keys)를
        찾을 수도 있다. 각각의 열쇠에는 number가 쓰여져 있고, 해당 번호에 해당하는 방을 잠금해제할 수 있다. 열쇠뭉치는 모두 가져갈
        수 있고, 언제든 방문을 열기위해 사용할 수 있다.

        문제에서 rooms 배열이 주어지고, rooms[i]는 해당 방에서 얻을 수 있는 열쇠뭉치 목록을 표현한다.
        모든 방을 visit할 수 있다면 True, 그렇지 않으면 False를 반환하라.

        input rooms = [{1}, {2}, {3}, {}]
        output : true

        해당 문제 조건에서 0번방은 항상 오픈된 상태

        예제를 예로 들면, 0->1->2->3 순으로 오픈이 되기에 그래프의 모양을 갖는다.

        그래프로 연관을 지은 후 풀이 알고리즘 생각하는것이 중요

        DFS의 시간복잡도는 o(v+e)
         */

        infBfsDfs main = new infBfsDfs();

        main.dfs(0);

        if(visited.size() == room.length){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    public void dfs(int v){
        visited.add(v);

        for(int next_v : room[v]){//연결된 정점을 순서대로 방문할 거기 때문에 int로 선언
            if(!visited.contains(next_v)){//리스트.contians를 쓸 경우 시간복잡도가 o(n)이기 때문에 Hashset같은걸 쓰는걸 추천
                dfs(next_v);
            }
        }
    }

    public void bfs(int v){
        Queue<Integer> q = new LinkedList<>();

        q.offer(v);
        bVisited[v] = true;
        while(!q.isEmpty()){
            int cur_v = q.poll();

            for(int next_v : room[cur_v]){
                if(!bVisited[next_v]){
                    q.offer(next_v);
                    bVisited[next_v] = true;
                }
            }
        }
    }
}
