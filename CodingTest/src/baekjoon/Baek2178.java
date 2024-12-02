package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2178 {
    static int graph [][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static int row;
    static int col;

    static boolean visited [][];


    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        graph = new int[row][col];
        visited = new boolean[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for(int j = 0; j < col; j++){
                graph[i][j] = tmp.charAt(j) - '0';
            }
        }

       bfs(0, 0);
    }

    public static void bfs(int x, int y){
        Queue<int []> q = new LinkedList<>();
        visited[x][y] = true;

        int path = 1;

        q.offer(new int[]{x, y, path});

        while(!q.isEmpty()){
            int poll [] = q.poll();
            int cur_x = poll[0];
            int cur_y = poll[1];
            int cur_p = poll[2];

            if(cur_x == row - 1 && cur_y == col -1){
                System.out.println(cur_p);
                return;
            }

            for(int i = 0; i < dx.length; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if((next_x >= 0 && next_x < row) && (next_y >= 0 && next_y < col)){
                    if(graph[next_x][next_y] == 1 && !visited[next_x][next_y]){
                        q.offer(new int [] {next_x, next_y, cur_p + 1});
                        visited[next_x][next_y] = true;
                    }
                }
            }
        }
    }
}
