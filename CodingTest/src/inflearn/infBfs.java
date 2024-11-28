package inflearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class infBfs {
    public static void main(String[] args) {
        /*
        그래프 순회 : 그래프 탐색이라고도 불리며, 그래프의 각 정점(Vertex)을 방문하는 과정을 말한다. 그래프
        순회에는 크게 깊이 우선 탐색(Depth-First Search/DFS)과 너비 우선 탐색(Breadth-First Search/BFS)
        의 2가지 알고리즘이 있다.

        BFS의 특징
            ㄴ 아래 코드를 예시로 들 때, 시작점과 가장 가까이 있는 정점부터 방문하며, 그 후 점점 멀어지는 정점 순서대로 탐색한다.
            ㄴ FIFO의 구조를 갖고잇음(queue)
         */

        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();

        ArrayList<Character> node1 = new ArrayList<>();
        node1.add('B');
        node1.add('D');
        node1.add('E');
        graph.put('A', node1);

        ArrayList<Character> node2 = new ArrayList<>();
        node2.add('A');
        node2.add('C');
        node2.add('D');
        graph.put('B', node2);

        ArrayList<Character> node3 = new ArrayList<>();
        node3.add('B');
        graph.put('C', node3);

        ArrayList<Character> node4 = new ArrayList<>();
        node4.add('A');
        node4.add('B');
        graph.put('D', node4);

        ArrayList<Character> node5 = new ArrayList<>();
        node5.add('A');
        graph.put('E', node5);


        infBfs main = new infBfs();

        LinkedList<Character> result = main.bfs(graph, 'A');
        System.out.println(result);

    }

    public LinkedList<Character> bfs (HashMap<Character, ArrayList<Character>> graph, char v){
        Queue<Character> q = new LinkedList<>(); //큐 선언
        LinkedList<Character> visit = new LinkedList<>(); //리턴할 배열 선언

        visit.add(v);//시작 점 방문
        q.offer(v); //시작 점 큐에 추가

        while(!q.isEmpty()){
            char curV = q.poll();// 시작 점 추출

            for(char vi : graph.get(curV)){ //탐색한 정점에 대한 인접 값 리스트 vi에 반환
                if(!visit.contains(vi)){ //이미 방문한 곳이 아닐 경우
                    visit.add(vi); //정점 방문 진행
                    q.add(vi); //시작점이 아닌 미방문 지점 큐에 추가
                }
            }

        }
        return visit;
    }
}
