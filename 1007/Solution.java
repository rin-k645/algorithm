import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static ArrayList<Integer>[] adList;
    static ArrayList<Integer>[] reversedList;
    static boolean[] visited;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
             
            adList = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++) {
                adList[i] = new ArrayList<>();
            }
             
            reversedList = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++) {
                reversedList[i] = new ArrayList<>();
            }
             
            int M = Integer.parseInt(br.readLine());
             
            for(int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
             
                adList[a].add(b);
                reversedList[b].add(a);
            }
             
            //구현
            //자신의 몇 번째인지 알 수 있는 경우 : 들어오는 간선 개수 + 본인 기준 탐색했을 때 연결되는 개수 = N - 1
            int count = 0;
            for(int i = 1; i <= N; i++) {
                visited = new boolean[N + 1];
                int taller = bfs(adList, i);
                 
                visited = new boolean[N + 1];               
                int smaller = bfs(reversedList, i);
                 
                if(taller + smaller == N - 1) {
                    count++;
                }
            }
             
            //출력
            System.out.println("#" + t + " " + count);
        }
    }
 
    public static int bfs(ArrayList<Integer>[] list, int v) {
        Queue<Integer> queue = new LinkedList<>();
         
        queue.add(v);
        visited[v] = true;
         
        int count = 0;
        while(!queue.isEmpty()) {
            int p = queue.poll();
             
            for(int n : list[p]) {
                if(!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                    count++;
                }
            }
        }
         
        return count;
    }
 
}
