package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1303 {
    static int C;
    static int R;

    static char graph [][];
    static boolean visited [][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static int wh = 0;
    static int bl = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int ansWh = 0;
        int ansBl = 0;


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

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!visited[i][j] && graph[i][j] == 'W'){
                    wh = 0;
                    dfs(i, j, 'W');
                    ansWh += wh * wh;

                }else if(!visited[i][j] && graph[i][j] == 'B'){
                    bl = 0;
                    dfs(i, j, 'B');
                    ansBl += bl * bl;
                }
            }
        }

        System.out.println(ansWh + " " + ansBl);
    }

    public static void dfs(int x, int y, char tmp){
        visited[x][y] = true;
        if(graph[x][y] == 'B'){
            bl++;
        }
        if(graph[x][y] == 'W'){
            wh++;
        }

        for(int i = 0; i < dx.length; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if((next_x >= 0 && next_x < R) && (next_y >= 0 && next_y < C)){
                if(!visited[next_x][next_y] && graph[next_x][next_y] == 'B' && tmp == 'B'){
                    dfs(next_x, next_y, 'B');
                }else if(!visited[next_x][next_y] && graph[next_x][next_y] == 'W' && tmp == 'W'){
                    dfs(next_x, next_y, 'W');
                }
            }
        }
    }
}
