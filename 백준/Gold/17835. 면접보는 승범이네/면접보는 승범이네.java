import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Edge>());
        }
        
        for (int i = 0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(v).add(new Edge(u, dist));
        }
        
        long ans = 0;
        int ansLoc = 0;
        st = new StringTokenizer(br.readLine());
        long[] dist = new long[N+1];
        Arrays.fill(dist, 100_000_000_000L);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            int exam = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(exam, 0));
            dist[exam] = 0;
        }
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curLoc = cur.loc;
            long curDist = cur.dist;
            if (dist[curLoc] < curDist) continue;
            for (Edge nxt: graph.get(curLoc)) {
                int nxtLoc = nxt.loc;
                long nxtDist = curDist + nxt.dist;
                if (nxtDist < dist[nxtLoc]) {
                    dist[nxtLoc] = nxtDist;
                    pq.offer(new Edge(nxtLoc, nxtDist));
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
                ansLoc = i;
            }
        }
        System.out.println(ansLoc);
        System.out.println(ans);
    }
    
    static class Edge implements Comparable<Edge>{
        int loc;
        long dist;
        
        public Edge(int loc, long dist) {
            this.loc = loc;
            this.dist = dist;
        }
 
        public int compareTo(Edge o) {
            return Long.compare(this.dist, o.dist);
        }
    }
}