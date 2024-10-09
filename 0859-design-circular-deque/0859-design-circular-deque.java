class MyCircularDeque {
    int front = -1, rear = -1;
    int[] deque;
    int size;
    public MyCircularDeque(int k) {
        deque = new int[k];
        size = k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(isEmpty()){front = 0; rear =  0;}
        deque[front] = value;
        front = (front + 1) % size;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(isEmpty()){front = 0; rear =  0;}
        if (rear == 0){
            rear = size - 1;
        }
        else rear--;
        deque[rear] = value;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(front == 0) front = size - 1;
        else front--;
        if(front == rear) {front = -1; rear = -1;}
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = (rear + 1) % size;
        if(front == rear) {front = -1; rear = -1;}
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        if(front == 0) return deque[size - 1];
        return deque[front - 1];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return deque[rear];
    }
    
    public boolean isEmpty() {
        if(front == -1 && rear == -1) return true;
        else return false;
    }
    
    public boolean isFull() {
        if (!isEmpty() && front == rear) return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */