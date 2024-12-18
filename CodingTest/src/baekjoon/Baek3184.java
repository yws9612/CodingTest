package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek3184 {
    static int R;
    static int C;

    static int sh = 0;
    static int wo = 0;

    static char [][] graph;
    static boolean [][] visited;

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];

        int ansSheep = 0;
        int ansWolf = 0;

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for(int j = 0; j < C; j++){
                char k = tmp.charAt(j);
                graph[i][j] = k;
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!visited[i][j] && (graph[i][j] == 'o' || graph[i][j] == 'v')){
                    sh = wo = 0;
                    dfs(i, j);

                    if(sh > wo){
                        ansSheep += sh;
                    }else{
                        ansWolf += wo;
                    }
                }
            }
        }

        System.out.println(ansSheep + " " + ansWolf);
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;

        if(graph[x][y] == 'o'){
            sh++;
        }
        if(graph[x][y] == 'v'){
            wo++;
        }

        for(int i = 0; i < dx.length; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if((next_x >= 0 && next_x < R) && (next_y >= 0 && next_y < C)){
                if(!visited[next_x][next_y] && graph[next_x][next_y] != '#'){
                    visited[next_x][next_y] = true;
                    dfs(next_x, next_y);
                }
            }
        }
    }
}
