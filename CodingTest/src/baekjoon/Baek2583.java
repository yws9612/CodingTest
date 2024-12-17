package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2583 {
    static int M;
    static int N;
    static int K;

    static int x1;
    static int y1;
    static int x2;
    static int y2;

    static int graph[][];
    static boolean visited[][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int rslt = 0;

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine(), " ");

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for(int j = y1; j < y2; j++){
                for(int k = x1; k < x2; k++){
                    graph[j][k] = 1;
                }
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && graph[i][j] == 0){
                    int data = bfs(i, j);
                    arr.add(data);
                    rslt++;
                }
            }
        }

        System.out.println(rslt);
        Collections.sort(arr);
        for(int i=0; i< arr.size(); i++){
            System.out.print(arr.get(i)+" ");
        }
    }

    public static int bfs(int x, int y){
        Queue<int []> q = new LinkedList<>();
        visited[x][y] = true;
        int val = 1;
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int poll [] = q.poll();
            int cur_x = poll[0];
            int cur_y = poll[1];

            for(int i = 0; i < dx.length; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if((next_x >= 0 && next_x < M) && (next_y >= 0 && next_y < N)){
                    if(!visited[next_x][next_y] && graph[next_x][next_y] == 0){
                        visited[next_x][next_y] = true;
                        q.offer(new int[]{next_x, next_y});
                        val++;
                    }
                }
            }
        }
        return val;
    }

}
