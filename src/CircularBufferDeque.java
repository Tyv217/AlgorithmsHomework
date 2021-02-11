public class CircularBufferDeque {
    static final int max = 100;
    int[] arr;
    int  front;
    int  end;
    int  size;

    public CircularBufferDeque(int size) {
        arr = new int[max];
        front = -1;
        end = 0;
        this.size = size;
    }

    boolean isFull() {
        return ((front == 0 && end == size-1) ||  front == end+1);
    }

    // Checks whether Deque is empty or not.
    boolean isEmpty () {
        return (front == -1);
    }

    public void insertFront(int key) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (front == -1) {
            front = 0;
            end = 0;
        }
        else if (front == 0){
            front = size - 1;
        }

        else{
            front--;
        }
        arr[front] = key ;
    }

    public void insertEnd(int key) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (front == -1) {
            front = 0;
            end = 0;
        }
        else if (end == size-1){
            end = 0;
        }
        else{
            end++;
        }
        arr[end] = key ;
    }

    public int popFront(){
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int popped;
        if (front == end) {
            popped = arr[front];
            front = -1;
            end = -1;
        }
        else {
            popped = arr[front];
            if (front == size - 1) {
                front = 0;
            } else {
                front = front + 1;
            }
        }
        return popped;
    }

    // Delete element at rear end of Deque
    public int popEnd() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int popped;
        if (front == end) {
            popped = arr[front];
            front = -1;
            end = -1;
        } else if (end == 0) {
            popped = arr[front];
            end = size - 1;
        } else {
            popped = arr[front];
            end--;
        }
        return popped;
    }
}