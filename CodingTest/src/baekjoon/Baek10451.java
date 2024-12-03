package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10451 {

    static int graph [];
    static boolean visited [];


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            int result = 0;
            int cnt = Integer.parseInt(st.nextToken());
            graph = new int[cnt + 1];
            visited = new boolean[cnt + 1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < graph.length; j++) {
                graph[j] = Integer.parseInt(st.nextToken());
            }

            for(int k = 1; k <= cnt; k++ ){
                if(!visited[k]){
                    dfs(k);
                    result++;
                }
            }
            System.out.println(result);
        }

    }

    public static void dfs(int start){
        visited[start] = true;
        int next = graph[start];
        if(!visited[next]){
            dfs(next);
        }
    }
}
