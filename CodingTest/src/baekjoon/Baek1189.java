package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1189 {
    static int R;
    static int C;
    static int T;

    static char graph [][];
    static boolean visited[][];

    static int dx [] = {-1, 1, 0, 0};
    static int dy [] = {0, 0, -1, 1};

    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for(int j = 0; j < C; j++){
                char k = tmp.charAt(j);
                graph[i][j] = k;
            }
        }

        dfs(R-1, 0, 1);

        System.out.println(cnt);

    }

    public static void dfs(int x, int y, int move){
        visited[x][y] = true;
        if(x == 0 && y == C-1){
            if(move == T){
                cnt++;
            }
            return;
        }
        for(int i = 0; i < dx.length; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if((next_x >= 0 && next_x < R) && (next_y >= 0 && next_y < C)){
                if(!visited[next_x][next_y] && graph[next_x][next_y] != 'T'){
                    visited[next_x][next_y] = true;
                    dfs(next_x, next_y, move + 1);
                    visited[next_x][next_y] = false;
                }
            }
        }
    }
}
