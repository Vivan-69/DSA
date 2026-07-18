import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, d));
            }
        }
        
        Collections.sort(edges, (a, b) -> Integer.compare(a.w, b.w));
        
        UFDS ds = new UFDS(n);
        int minCost = 0;
        int edgesConnected = 0;
        
        for (Edge edge : edges) {
            if (ds.union(edge.u, edge.v)) {
                minCost += edge.w;
                edgesConnected++;
                if (edgesConnected == n - 1) {
                    break;
                }
            }
        }
        return minCost;
    }

    class Edge {
        int u, v, w;
        
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    class UFDS {
        int[] parent;

        public UFDS(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y) {
            int leaderx = find(x);
            int leadery = find(y);

            if (leaderx == leadery) {
                return false;
            }
            parent[leadery] = leaderx;
            return true;
        }
    }
}