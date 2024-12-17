package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek13565 {
    static int M;
    static int N;
    static int graph [][];
    static boolean visited [][];

    static int dx [] = {-1, 1, 0, 0};
    static int dy [] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean chk = false;

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < N; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }


        for(int j = 0; j < N; j++){
            if(!visited[0][j] && graph[0][j] == 0){
                dfs(0, j);
            }
        }

        System.out.println("NO");

    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        if(x == M-1){
            System.out.println("YES");
            System.exit(0);
        }
        for(int i = 0; i < dx.length; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if((next_x >= 0 && next_x < M) && (next_y >= 0 && next_y < N)){
                    if(!visited[next_x][next_y] && graph[next_x][next_y] == 0){
                        visited[next_x][next_y] = true;
                        dfs(next_x, next_y);
                    }
                }

        }
    }
}
