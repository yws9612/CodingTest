package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1743 {
    static int row;
    static int col;
    static int turn;

    static int result = 1;

    static int graph [][];
    static boolean visited[][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        turn = Integer.parseInt(st.nextToken());

        graph = new int[row+1][col+1];
        visited = new boolean[row+1][col+1];

        for(int i = 0; i < turn; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
        }

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    bfs(i, j);
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs(int x, int y){
        Queue<int []> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        int wide = 1;

        while(!q.isEmpty()){
            int poll [] = q.poll();
            int cur_x = poll[0];
            int cur_y = poll[1];

            for(int i = 0; i < dx.length; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if((next_x >= 0 && next_x <= row) && (next_y >= 0 && next_y <= col)){
                    if(!visited[next_x][next_y] && graph[next_x][next_y] == 1){
                        visited[next_x][next_y] = true;
                        q.offer(new int[]{next_x, next_y});
                        wide++;
                    }
                }
            }
        }
        result = Math.max(result, wide);
    }
}
