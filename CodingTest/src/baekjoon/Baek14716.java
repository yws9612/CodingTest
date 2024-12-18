package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek14716 {
    static int R;
    static int C;

    static int graph [][];
    static boolean visited [][];

    static int dx [] = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int dy [] = {0, 0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void bfs(int x, int y){
        Queue<int []> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int poll [] = q.poll();
            int cur_x = poll[0];
            int cur_y = poll[1];

            for(int i = 0; i < dx.length; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if((next_x >= 0 && next_x < R) && (next_y >= 0 && next_y < C)){
                    if(!visited[next_x][next_y] && graph[next_x][next_y] == 1){
                        visited[next_x][next_y] = true;
                        q.offer(new int[]{next_x, next_y});
                    }
                }
            }
        }
    }
}
