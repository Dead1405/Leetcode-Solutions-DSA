class Node {
    int start, end, count;
    Node left, right;

    public Node(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }
    
    static public Node insert(Node root, int s, int e,int count, int[] ans) {
        //return when null
        if (root == null) return new Node(s, e, count);
        //go left
        if (e <= root.start) root.left = insert(root.left, s, e, count, ans);
        //go right
        else if (s >= root.end) root.right = insert(root.right, s, e, count, ans);
        //conflict
        else {
            if (s < root.start) root.left = insert(root.left, s, root.start, count, ans);
            else if (s > root.start) {
                root.left = insert(root.left, root.start, s, root.count, ans);
                root.start = s;
            }
            if (root.end < e) root.right = insert(root.right, root.end, e, count, ans);
            else if (e < root.end) {
                root.right = insert(root.right, e, root.end, root.count, ans);
                root.end = e;
            }
            root.count += count;
            if(root.count > ans[0]) ans[0] = root.count;
        }
        return root;
    }
}

class MyCalendarThree {
    //i can't let time complexity of each operation be n log n
    //that way
    int[] ans;
    public MyCalendarThree(){
        ans = new int[1];
        ans[0] = 1;
    }
    Node root = null;
    public int book(int start, int end) {
        root = Node.insert(root, start, end, 1, ans);
        return ans[0];
    }
}
