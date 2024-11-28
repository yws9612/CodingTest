package inflearn;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class infDfs {

    LinkedList<Character> visited = new LinkedList<>();
    HashMap<Character, ArrayList<Character>> graph = new HashMap<>();

    public static void main(String[] args) {
        /*
        BFS와 달리 DFS는 시작 정점부터 연결된 최심부 까지 탐색 후 다시 돌아와서 해당 행위를 반복하여 탐색하는 방법이다.
         */

        infDfs main = new infDfs();

        ArrayList<Character> node1 = new ArrayList<>();
        node1.add('B');
        node1.add('D');
        node1.add('E');
        main.graph.put('A', node1);

        ArrayList<Character> node2 = new ArrayList<>();
        node2.add('A');
        node2.add('C');
        node2.add('D');
        main.graph.put('B', node2);

        ArrayList<Character> node3 = new ArrayList<>();
        node3.add('B');
        main.graph.put('C', node3);

        ArrayList<Character> node4 = new ArrayList<>();
        node4.add('A');
        node4.add('B');
        main.graph.put('D', node4);

        ArrayList<Character> node5 = new ArrayList<>();
        node5.add('A');
        main.graph.put('E', node5);


          //1번 코드에 사용될 변수 초기값 및 함수 실행 구문
//        LinkedList<Character> aa = new LinkedList<>();

//        LinkedList<Character> result = main.dfs(graph, 'A', aa);
//        System.out.println(result);

        //2번 코드에 사용될 변수 초기값 및 함수 실행 구문
        main.dfs('A');
        System.out.println(main.visited);

    }

      //1. 그래프, 현재 정점, 방문 현황을 모두 매개변수로 받는 함수
//    public LinkedList<Character> dfs(HashMap<Character, ArrayList<Character>> graph, char cur_v, LinkedList<Character> visited){
//        visited.add(cur_v);// 초기 방문 점 방문 배열에 추가
//
//        for(char v : graph.get(cur_v)){//그래프의 해당 방문점에 대한 모든 값들을 v에 저장
//            if(!visited.contains(v)){//방문점에 v가 존재하지 않는 경우
//                visited = dfs(graph, v, visited);//방문점 v에 해당하는 dfs 함수 실행
//            }
//        }
//        return visited;
//    }

    //2. 현재 정점만 매개변수로 받는 함수
    public void dfs(char cur_v){
        visited.add(cur_v);//초기 방문 점
        for(char v : graph.get(cur_v)){
            if(!visited.contains(v)){
                dfs(v); //정점과 관련된 다른 정점에게 방문 권한을 위임
            }
        }
    }
}
