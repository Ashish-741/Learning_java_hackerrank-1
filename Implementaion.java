import java.util.*;
class Implementation {
    public static void main(String[] args) {
        graph g=new graph(4);
        g.addedge(1, 2, 10);
        g.addedge(1, 3, 15);
        g.addedge(2, 4, 12);
        g.addedge(3, 4, 10);
        g.display();
        System.out.println(g.containedge(1,2));
        System.out.println(g.containedge(1,4));
        
        System.out.println(g.noofedge());
        
        
        g.printpath(1,4,new HashSet<>(),"");
        
    }
    public static class graph{
        HashMap<Integer, HashMap<Integer,Integer>> map;
        public graph(int n){
            map=new HashMap<>();
            for(int i=1;i<=n;i++){
                map.put(i,new HashMap<>());
            }
        }
        public void addedge(int v1,int v2,int cost){
            map.get(v1).put(v2,cost);
            map.get(v2).put(v1,cost);
        }
        public void display(){
            for(int key:map.keySet()){
                System.out.println(key+" --> "+map.get(key));
            }
        }
        public boolean containedge(int v1,int v2){
            return map.get(v1).containsKey(v2);
        }
        public boolean containvertex(int v1){
            return map.containsKey(v1);
        }
        public int noofedge(){
            int sum=0;
            for(int key:map.keySet()){
                sum+=map.get(key).size();
            }
            return sum/2;
        }
        public void removeedge(int v1,int v2){
            map.get(v1).remove(v2);
            map.get(v2).remove(v1);
        }
        public void removevertex(int v1){
            for(int key:map.get(v1).keySet()){
                map.get(key).remove(v1);
            }
            map.remove(v1);
        }
        public boolean haspath(int v1,int v2,HashSet<Integer> visited){
            if(v1==v2){
                return true;
            }
            visited.add(v1);
            for(int nbrh:map.get(v1).keySet()){
                if(!visited.contains(nbrh)){
                    boolean ans=haspath(nbrh,v2,visited);
                    if(ans){
                        return true;
                    }
                }
            }
            return false;
        }
        public void printpath(int v1,int v2,HashSet<Integer> visited,String ans){
            if(v1==v2){
                System.out.println(ans);
                return;
            }
            visited.add(v1);
            for(int nbrh:map.get(v1).keySet()){
                if(!visited.contains(nbrh)){
                    printpath(nbrh,v2,visited,ans+v1);
                }
            }
            visited.remove(v1);
        }
    }
}