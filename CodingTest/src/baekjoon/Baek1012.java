package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1012 {
    static int n;

    static int m;
    static int z;

    static int graph [][];
    static boolean visited[][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int result = 0;

            graph = new int[m][z];
            visited = new boolean[m][z];

            for(int j = 0; j < row; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = 1;
            }

            for(int k = 0; k < m; k ++){
                for(int l = 0; l < z; l++){
                    if(!visited[k][l] && graph[k][l] == 1){
                        bfs(k, l);
                        result++;
                    }
                }
            }

            for(int k = 0; k < m; k ++){
                for(int l = 0; l < z; l++){
                    if(!visited[k][l] && graph[k][l] == 1){
                        dfs(k, l);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < dx.length; i++){
            int cur_x = x + dx[i];
            int cur_y = y + dy[i];

            if((cur_x >= 0 && cur_x < m) && (cur_y >= 0 && cur_y < z)){
                if(!visited[cur_x][cur_y] && graph[cur_x][cur_y] == 1){
                    dfs(cur_x, cur_y);
                }
            }
        }
    }

    public static void bfs(int x, int y){
        Queue<int []> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[] {x,y});

        while(!q.isEmpty()){
            int poll [] = q.poll();
            int cur_x = poll[0];
            int cur_y = poll[1];

            for(int i = 0; i < dx.length; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if((next_x >= 0 && next_x < m) && (next_y >= 0 && next_y < z)){
                    if(!visited[next_x][next_y] && graph[next_x][next_y] == 1){
                        visited[next_x][next_y] = true;
                        q.offer(new int[] {next_x, next_y});
                    }
                }
            }
        }
    }
}
