package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2644 {
    static int M;
    static int N;
    static int result = -1;

    static int a;
    static int b;

    static int graph [][];
    static boolean visited [];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        graph = new int [N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

        dfs(a, 0);

        System.out.println(visited[b] ? result : -1);
    }

    public static void dfs(int start, int cnt){
        visited[start] = true;
        if(start == b){
            result = cnt;
            return;
        }
        for(int i = 1; i < graph.length; i++){
            if(!visited[i] && graph[start][i] == 1){
                dfs(i, cnt + 1);
            }
        }

    }
}
