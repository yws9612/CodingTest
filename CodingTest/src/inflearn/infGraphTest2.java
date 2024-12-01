package inflearn;

import java.util.LinkedList;
import java.util.Queue;

public class infGraphTest2 {
//    static int [][] graph = {
//            {0, 0, 0, 1, 0, 0, 0},
//            {0, 1, 1, 1, 0, 1, 0},
//            {0, 1, 0, 0, 0, 1, 0},
//            {0, 0, 0, 1, 1, 1, 0},
//            {0, 1, 0, 0, 0, 0, 0}
//    };

    static int [][] graph = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0},
    };

    static int dx [] = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int dy [] = {0, 0, -1, 1, -1, 1, 1, -1};

    static int row = graph.length;
    static int col = graph[0].length;

    static boolean visited [][] = new boolean[row][col];

    public static void main(String[] args) {
        /*
        문제
        n x n binary matrix(2중 리스트)인 grid가 주어졌을 때, 출발지에서 목적지까지 도착하는 가장 빠른 경로의
        길이를 반환하시오. 만약 경로가 없다면 -1을 반환하시오.

        출발지 : top-left cell
        목적지 : bottom - right cell

        - 값이 0인 cell만 지나갈 수 있다.
        - cell끼리는 8가지 방향으로 연결되어 있다. (edge와 corner 방향으로 총 8가지이다.)
        - 연결된 cell을 통해서만 지나갈 수 있다.

        BFS는 모든 정점을 최대 한번씩 방문해서 *최단거리*가 어디인지 파악할 수 있는 알고리즘(시간 복잡도 O(v) => o(n^2))
        ex) 미로찾기, 최단거리 문제 = BFS(Level By Level)
        DFS일 경우 한 경로에 대핸 탐색을 실행했을 때 최단거리인지 확인할 수 없고, 모든 경우의 수를 다 따져야하기 때문에 BFS가 실용적임.
         */

        infGraphTest2 main = new infGraphTest2();
        int result = main.bfs(graph);

        System.out.println(result);


    }

    public int bfs(int [][] graph){
        Queue<int []> q = new LinkedList<>();

        int path = -1;//초기 경로 값 세팅

        if(graph[0][0] != 0 || graph[row-1][col-1] == 1){ //시작점/종료 지점이 0이 아닐 경우 길이 없어 -1로 반환
            return path;
        }
        visited[0][0] = true;
        q.offer(new int[]{0, 0, 1});//시작점부터 길이가 1이기 때문에 시작 정점, 길이로 큐 추가

        while(!q.isEmpty()){
            int [] cur = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            int cur_len = cur[2];

            if(cur_x == row - 1 && cur_y == col - 1){//x, y값이 종료 지점에 왔을 때 path를 큐의 현재 경로값으로 설정 후 반복문 종료
                path = cur_len;
                break;
            }

            for(int i = 0; i < dx.length; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if((next_x >= 0 && next_x < row) && (next_y >= 0 && next_y < col)){
                    if(graph[next_x][next_y] == 0 && !visited[next_x][next_y]){
                        q.offer(new int [] {next_x, next_y, cur_len + 1});//다음 x, y값이 큐에 추가 될 때 경로값도 + 1
                        visited[next_x][next_y] = true;
                    }
                }
            }
        }
        return path;
    }
}
