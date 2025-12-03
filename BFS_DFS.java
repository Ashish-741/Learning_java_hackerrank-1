import java.util.*;

public class BFS_DFS {
    public static class Graph {
        HashMap<Integer, HashMap<Integer,Integer>> map;
        public Graph(int n) {
            map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(i, new HashMap<>());
            }
        }
        public void addedge(int v1, int v2, int cost) {
            map.get(v1).put(v2, cost);
            map.get(v2).put(v1, cost);
        }

        public boolean bfs(int src, int des) {
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            HashSet<Integer> visited = new HashSet<>();

            while (!q.isEmpty()) {
                int rv = q.poll();

                if (visited.contains(rv)) continue;

                visited.add(rv);

                if (rv == des) return true;

                for (int nbr : map.get(rv).keySet()) {
                    if (!visited.contains(nbr)) q.add(nbr);
                }
            }
            return false; // return after traversal finishes
        }

        public boolean dfs(int src, int des) {
            Stack<Integer> s = new Stack<>();
            s.push(src);
            HashSet<Integer> visited = new HashSet<>();

            while (!s.isEmpty()) {
                int rv = s.pop();

                if (visited.contains(rv)) continue;

                visited.add(rv);

                if (rv == des) return true;

                for (int nbr : map.get(rv).keySet()) {
                    if (!visited.contains(nbr)) s.push(nbr);
                }
            }
            return false; // return after traversal finishes
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addedge(1, 2, 10);
        g.addedge(1, 3, 15);
        g.addedge(2, 4, 12);
        g.addedge(3, 4, 10);

        System.out.println("BFS 1->4: " + g.bfs(1, 4));
        System.out.println("DFS 1->4: " + g.dfs(1, 4));
        System.out.println("BFS 1->3: " + g.bfs(1, 3));
    }
}
