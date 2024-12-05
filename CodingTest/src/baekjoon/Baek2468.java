package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2468 {

    /*
    해당 문제 같은 경우, 강수량이 있을 경우의 최대값을 구하는 것으로, 따로 높이가 나와있지 않기 때문에 입력되어있는 높이 중
    최대 높이를 max로 설정하여 안전 가옥이 얼마나 있는지를 계산해야됨. ***문제 꼼꼼히 읽을 것!***
     */

    static int n;

    static int graph [][];
    static boolean visited [][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;

        n = Integer.parseInt(st.nextToken());

        graph = new int[n][n];


        int max = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int temp = Integer.parseInt(st.nextToken());
                graph[i][j] = temp;
                max = Math.max(max, temp);
            }
        }

        for(int k = 0; k < max; k++){
            int val = 0;
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!visited[i][j] && graph[i][j] > k){
                        bfs(i, j, k);
                        val++;
                    }
                }
            }
            result = Math.max(val, result);
        }
        System.out.println(result);
    }

    public static void bfs(int x, int y, int h){
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

                if((next_x >= 0 && next_x < n) && (next_y >= 0 && next_y < n)){
                    if(!visited[next_x][next_y] && graph[next_x][next_y] > h){
                        visited[next_x][next_y] = true;
                        q.offer(new int[] {next_x, next_y});
                    }
                }
            }
        }
    }
}
