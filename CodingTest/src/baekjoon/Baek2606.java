package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2606 {

    static int v;
    static int e;

    static int result = 0;

    static int graph [][];
    static boolean visited [];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        e = Integer.parseInt(st.nextToken());

        graph = new int[v+1][v+1];
        visited = new boolean[v+1];

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

        dfs(1);

        System.out.println(result);
    }

    public static void dfs(int start){
        visited[start] = true;

        for(int i = 0; i < graph.length; i++){
            if(!visited[i] && graph[start][i] == 1){
                dfs(i);
                result++;
            }
        }
    }
}
