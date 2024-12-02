package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1260 {
    static int v;
    static int n;
    static int m;

    static int vertex [][];
    static boolean visited [];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        vertex = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            vertex[x][y] = vertex[y][x] = 1;
        }

        dfs(v);
        System.out.println();

        visited = new boolean[n+1];
        bfs(v);
    }

    public static void dfs(int x){
        visited[x] = true;
        System.out.print(x + " ");
        for(int i = 0; i < vertex.length; i++){
            if(vertex[x][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        visited[x] = true;
        q.offer(x);
        System.out.print(x + " ");
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i = 0; i < vertex.length; i++){
                if(!visited[i] && vertex[tmp][i] == 1){
                    q.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
