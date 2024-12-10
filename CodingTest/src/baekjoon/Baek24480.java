package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek24480 {
    static int M;
    static int N;

    static int cnt = 1;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited [];
    static int result [];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new boolean[M+1];
        result = new int[M+1];

        for(int i = 0; i <= M; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i = 1; i <= M; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }
        dfs(start);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < result.length; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int start){
        visited[start] = true;
        result[start] = cnt++;

        for(int val : graph.get(start)){
            if(!visited[val]){
                visited[val] = true;
                dfs(val);
            }
        }
    }
}
