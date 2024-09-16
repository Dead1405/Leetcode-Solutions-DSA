class Solution {
    public int findCenter(int[][] edges) {
        ArrayList<Integer> found = new ArrayList<>();
        found.add(edges[0][0]);
        found.add(edges[0][1]);
        if (found.contains(edges[1][0])) return edges[1][0];
        else return edges[1][1];
    }
}