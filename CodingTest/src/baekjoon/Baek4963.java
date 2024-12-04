package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek4963 {
    static int graph [][];
    static boolean visited [][];

    static int n;
    static int m;

    static int dx [] = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int dy [] = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            int result = 0;

            graph = new int[m][n];
            visited = new boolean[m][n];

            if(n == 0 && m == 0){
                break;
            }
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    int val = Integer.parseInt(st.nextToken());
                    graph[i][j] = val;
                }
            }

            for(int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if(!visited[i][j] && graph[i][j] == 1){
                        bfs(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static void bfs(int x, int y){
        Queue<int []> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[] {x, y});

        while(!q.isEmpty()){
            int poll [] = q.poll();
            int cur_x = poll[0];
            int cur_y = poll[1];

            for(int i = 0; i < dx.length; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if((next_x >= 0 && next_x < m) && (next_y >= 0 && next_y < n)){
                    if(!visited[next_x][next_y] && graph[next_x][next_y] == 1){
                        visited[next_x][next_y] = true;
                        q.offer(new int[] {next_x, next_y});
                    }
                }
            }
        }
    }
}
