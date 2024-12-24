package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek16930 {
    static int R;
    static int C;
    static int K;

    static char graph [][];
    static boolean visited [][];

    static int result = Integer.MAX_VALUE;
    static int len = 1;

    static int x1;
    static int x2;
    static int y1;
    static int y2;

    static int dx [] = {-1, 1, 0, 0};
    static int dy [] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for(int j = 0; j < C; j++){
                char ch = tmp.charAt(j);
                graph[i][j] = ch;
            }
        }
        st = new StringTokenizer(br.readLine());

        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        bfs(x1, y1, 0);

        System.out.println(result == 0 ? -1 : result);
    }

    public static void bfs(int x, int y, int d){
        Queue<int []> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[] {x, y, d});

        while(!q.isEmpty()){
            int poll [] = q.poll();
            int cur_x = poll[0];
            int cur_y = poll[1];
            int cur_d = poll[2];

            if(cur_x == x2 && cur_y == y2){
                result = Math.min(result, cur_d);
                break;
            }

            for(int i = 0; i < dx.length; i++){
                for(int k = 1; k <= K; k++){
                    int next_x = cur_x + (dx[i] * k);
                    int next_y = cur_y + (dy[i] * k);

                    if((next_x >= 0 && next_x < R) && (next_y >= 0 && next_y < C)){
                        if(!visited[next_x][next_y] && graph[next_x][next_y] != '#'){
                            visited[next_x][next_y] = true;
                            q.offer(new int[] {next_x, next_y, cur_d + 1});
                        }
                    }
                }
            }
        }
    }
}
