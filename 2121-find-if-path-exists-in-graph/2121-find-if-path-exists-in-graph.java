class Solution {
    public boolean DFS(ArrayList<Integer> adj[], boolean visited[], int node, int dest){
        if(node == dest) return true;
        for (int i : adj[node]){
            if(visited[i] == false){
                visited[i] = true;
                if(DFS(adj, visited, i, dest) == true) return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //create adjoincy list
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] i : edges){
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
        }
        // do dfs if destinatiopn found retur ntrue else return false
        boolean[] visited = new boolean[n];
        return DFS(adj, visited, source, destination);
    }
}