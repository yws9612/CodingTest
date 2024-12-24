package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek7576 {
    static int graph [][];

    static boolean visit = true;

    static Queue<int []> q = new LinkedList<>();

    static int col;
    static int row;

    static int cur_len = 0;

    static int result = 0;

    static int dx [] = {-1, 1, 0, 0};
    static int dy [] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean chkRes = false;

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        graph = new int[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                int val = Integer.parseInt(st.nextToken());
                graph[i][j] = val;
                if(graph[i][j] == 1){
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        result = bfs();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 0) { // 익지 않은 토마토가 있다면
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(result);
    }

    public static int bfs(){

        while(!q.isEmpty()){
            int [] cur = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            cur_len = cur[2];

            for(int i = 0; i < dx.length; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if((next_x >= 0 && next_x < row) && (next_y >= 0 && next_y < col) && graph[next_x][next_y] == 0){
                    graph[next_x][next_y] = 1;
                    q.offer(new int[] {next_x, next_y, cur_len + 1});
                }
            }
        }
        return cur_len;
    }
}
