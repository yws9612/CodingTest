package inflearn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class infGraphTest1 {
    static int [][] graph = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}
    };

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static int col = graph[0].length;
    static int row = graph.length;

    static boolean[][] visited = new boolean[row][col];

    static int result = 0;


    public static void main(String[] args) {
        /*
        문제 : grid는 "1"(land)과 "0"(water)으로 이루어진 지도를 표현하는 m x n 이차원 배열이다. 이 지도에 표시된 섬들의
        총 갯수를 반환하시오. 섬이란 수평과 수직으로 땅이 연결되어 있고 주변은 물로 둘러쌓여있는 것을 말한다. 또한, grid의 네개의
        가장자리는 모두 물로 둘러쌓여있다고 가정하고 문제를 해결하라.

        m == grid.length
        n == grid[i].length

        ex) grid = [
                    {1, 1, 1, 1, 0},
                    {1, 1, 0, 1, 0},
                    {1, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                   ]

         ex) grid = [
                    {1, 1, 0, 0, 0},
                    {1, 1, 0, 0, 0},
                    {0, 0, 1, 0, 0},
                    {0, 0, 0, 1, 1},
                   ]

         2차원 배열이기에 2중 for문을 사용하여 grid[i][j] == 1 && !visited 일 경우 bfs 실행

         접근 방식만 생각하면 bfs, dfs는 템플릿이 있기 때문에 큰 문제 없다.

         */
        infGraphTest1 main = new infGraphTest1();

        for(int i = 0; i < row; i++){//접근 방식 코드
            for(int j = 0; j < col; j++){
                if(graph[i][j] == 1 && !visited[i][j]){//명시적 그래프의 값이 1(땅)이고, 방문되지 않은곳이면
                    main.bfs(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public void bfs(int x, int y){
        visited[x][y] = true; //방문 활성화
        Queue<int []> q = new LinkedList<>();

        q.offer(new int[]{x, y}); //좌표 큐에 추가

        while(!q.isEmpty()){
            //현재 좌표 값 불러옴
            int poll[] = q.poll();
            int cur_x = poll[0];
            int cur_y = poll[1];

            for(int i = 0; i < dx.length; i++){ //이동할 수 있는 방향만큼 반복
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];
                if((next_x >= 0 && next_x < row) && (next_y >= 0 && next_y < col)){
                    if(graph[next_x][next_y] == 1 && !visited[next_x][next_y]){//다음 행의 x, y값이 땅이면서 방문하지 않은곳이면
                        visited[next_x][next_y] = true; //방문 활성화
                        q.offer(new int[]{next_x, next_y}); //큐에 다음 방문점 추가
                    }
                }
            }
        }

    }
}
