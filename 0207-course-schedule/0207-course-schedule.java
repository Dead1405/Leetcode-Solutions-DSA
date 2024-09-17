class Solution {
    //topo sort
    //make an stack to store int, boolean array visited, adjacency list
    public boolean canFinish(int V, int[][] pre) {
        //maek andjaceny list
        ArrayList<Integer>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++) adj[i] = new ArrayList<Integer>();
        //fill it
        for(int i = 0; i < pre.length; i ++){
            adj[pre[i][0]].add(pre[i][1]);
        }
        //made int array 0 mean unvisited 1 means not closed yet 2 means closed
        int[] visited = new int[V];
        // do dfs
        for(int i = 0; i< V; i++){
            if (visited[i] == 0 && DFS(adj, visited, i) == false){
                return false;
            }
        }
        return true;
        //recurring stack ready
        //instead of using stack just use hash set for faster lookups to find if it is found

    }

    boolean DFS (ArrayList<Integer>[] adj, int[] visited, int node){
        visited[node] = 1;
        for(int i : adj[node]){
            if(visited[i]==1) return false;
            if(visited[i] == 0 && DFS(adj, visited, i) == false){
                return false;
            }
        }
        visited[node] = 2;
        return true;
    }
}