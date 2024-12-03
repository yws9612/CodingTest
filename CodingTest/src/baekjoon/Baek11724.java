package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11724 {

    static int graph [][] = new int[1001][1001];
    static boolean visited [] = new boolean[1001];
    static int n;
    static int m;
    static int v;
    static int min;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

        for(int i = 1; i <= n; i++){
            if(!visited[i]){ //방문하지 않은 정점일 경우 함수 실행하여 해당 정점과 연결된 모든 정점을 방문 처리
                dfs(i);
                v++;
            }
        }
        System.out.println(v);
    }

    public static void dfs(int x){
        visited[x] = true;
        for(int i = 0; i < graph.length; i++){
            if(graph[x][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}
