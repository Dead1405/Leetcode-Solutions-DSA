class Node{
    int start;
    int end;
    Node left, right;
    Node(int start, int end){
        this.start = start;
        this.end = end;
        left = null;
        right = null;
    }

    boolean insert(int _start, int _end){
        if(_start <= start && _end <= start){
            if(this.left == null){
                this.left = new Node(_start, _end);
                return true;
            }
            else return this.left.insert(_start, _end);
        }
        else if(_start >= end && _end >= end){
            if(this.right == null){
                this.right = new Node(_start, _end);
                return true;
            }
            else return this.right.insert(_start, _end);
        }
        else{
            return false;
        }
    }
}
class MyCalendar {
    //lets use BST to store the bookings if to be booked has end timing and start timing before start time store left else if 
    //both are after end store right else return false
    Node root = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
    public boolean book(int start, int end) {
        return root.insert(start, end);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */