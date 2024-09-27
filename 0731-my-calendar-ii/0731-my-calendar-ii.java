class Node {
    int start, end, count = 1;
    Node left, right;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    static public boolean check(Node root, int s, int e) {
        if (root == null) return true;
        if (e <= root.start) return check(root.left, s, e);
        else if (s >= root.end) return check(root.right, s, e);
        else if (root.count == 2) return false;
        if (s < root.start && !check(root.left, s, root.start)) return false;
        if (root.end < e && !check(root.right, root.end, e)) return false;
        return true;
    }

    static public Node insert(Node root, int s, int e, boolean[] ans) {
        if (!ans[0]) return root;
        if (root == null) return new Node(s, e);
        if (e <= root.start) root.left = insert(root.left, s, e, ans);
        else if (s >= root.end) root.right = insert(root.right, s, e, ans);
        else {
            if (root.count == 2) ans[0] = false;
            if (s < root.start) root.left = insert(root.left, s, root.start, ans);
            else if (s > root.start) {
                root.left = insert(root.left, root.start, s, ans);
                root.start = s;
            }
            if (root.end < e) root.right = insert(root.right, root.end, e, ans);
            else if (e < root.end) {
                root.right = insert(root.right, e, root.end, ans);
                root.end = e;
            }
            if (ans[0]) root.count++;
        }
        return root;
    }
}

class MyCalendarTwo {
    Node root = null;

    public boolean book(int start, int end) {
        boolean[] ans = {true};
        if (Node.check(root, start, end)) {
            root = Node.insert(root, start, end, ans);
            return true;
        }
        return false;
    }
}
