import java.util.*;

public class transversal {

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
    }


    public void bft(Graph g){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        for(int key : g.map.keySet()){
            if(visited.contains(key)) continue;
            q.add(key);
            while(!q.isEmpty()){
                //1.remove
                int rv = q.poll();

                //2.ignore
                if(visited.contains(rv)) continue;

                //3.mark visited
                visited.add(rv);

                //4. self work
                System.out.print(rv+" ");

                //5.add nbrs visited
                for(int nbr : g.map.get(rv).keySet()){
                    if(!visited.contains(nbr)) q.add(nbr);
                }
            }
        }
    }
        public void dft(Graph g){
        Stack<Integer> s = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        for(int key : g.map.keySet()){
            if(visited.contains(key)) continue;
            s.push(key);
            while(!s.isEmpty()){
                //1.remove
                int rv = s.pop();

                //2.ignore
                if(visited.contains(rv)) continue;

                //3.mark visited
                visited.add(rv);

                //4. self work
                System.out.print(rv+" ");

                //5.add nbrs visited
                for(int nbr : g.map.get(rv).keySet()){
                    if(!visited.contains(nbr)) s.push(nbr);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addedge(1, 2, 10);
        g.addedge(1, 3, 10);
        g.addedge(2, 4, 10);
        g.addedge(5, 6, 10); // second connected component

        transversal t = new transversal();
        //t.bft(g);
        t.dft(g);
    }
}
