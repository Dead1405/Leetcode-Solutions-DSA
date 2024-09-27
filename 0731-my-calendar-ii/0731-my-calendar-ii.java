class Node {
    int start, end;  // Represents the interval [start, end)
    int count = 1;   // Counts how many bookings overlap in this interval
    Node left, right; // Left and right child nodes for binary tree structure

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    static public boolean check(Node root, int s, int e) {
        //if insertion possible return true
        // If root is null, create a new node for the interval and return it
        if (root == null) return true;

        // Case 1: New interval is entirely before the current interval (no overlap)
        if (e <= root.start) {
            return check(root.left, s, e); // Recur in the left subtree
        }
        // Case 2: New interval is entirely after the current interval (no overlap)
        else if (s >= root.end) {
            return check(root.right, s, e); // Recur in the right subtree
        }
        // Case 3: New interval overlaps with the current interval (potential conflict)
        else {
            // If this is a triple booking (i.e., count == 2), mark ans as false
            if (root.count == 2) {
                return false; // Triple booking is not allowed
            } else {
                // Otherwise, increment the count to indicate a double booking

                // Handle the left side of the new interval if needed
                if (s < root.start && check(root.left, s, root.start) == false) {
                    return false;
                } else if (s > root.start && check(root.left, root.start, s) == false) {
                    return false;
                }

                // Handle the right side of the new interval if needed
                if (root.end < e && check(root.right, root.end, e) == false) {
                    return false;
                } else if (e < root.end && check(root.right, e, root.end) == false) {
                    return false;
                }
                return true;
            }
        }
    }

    // Insert a new interval [s, e) into the tree
    static public Node insert(Node root, int s, int e, boolean[] ans) {
        if (ans[0] == false) return root;
        // If root is null, create a new node for the interval and return it
        if (root == null) return new Node(s, e);

        // Case 1: New interval is entirely before the current interval (no overlap)
        if (e <= root.start) {
            root.left = insert(root.left, s, e, ans); // Recur in the left subtree
        }
        // Case 2: New interval is entirely after the current interval (no overlap)
        else if (s >= root.end) {
            root.right = insert(root.right, s, e, ans); // Recur in the right subtree
        }
        // Case 3: New interval overlaps with the current interval (potential conflict)
        else {
            // If this is a triple booking (i.e., count == 2), mark ans as false
            if (root.count == 2) {
                ans[0] = false; // Triple booking is not allowed
            } else {
                // Otherwise, increment the count to indicate a double booking

                // Handle the left side of the new interval if needed
                if (s < root.start) {
                    root.left = insert(root.left, s, root.start, ans);
                } else if (s > root.start) {
                    root.left = insert(root.left, root.start, s, ans);
                    root.start = s; // Adjust start point after inserting left part
                }

                // Handle the right side of the new interval if needed
                if (root.end < e) {
                    root.right = insert(root.right, root.end, e, ans);
                } else if (e < root.end) {
                    root.right = insert(root.right, e, root.end, ans);
                    root.end = e; // Adjust end point after inserting right part
                }
                if (ans[0] == true)  root.count++;
            }
        }

        // Return the updated root node
        return root;
    }
}

class MyCalendarTwo {
    Node root = null; // The root of the BST

    public boolean book(int start, int end) {
        boolean[] ans = {true}; // Mutable array to store the result
        if(Node.check(root, start, end)){
            root = Node.insert(root, start, end, ans); // Update root with the result of insert   
            return true;
        }
        else return false;
    }
}
