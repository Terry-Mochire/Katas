public class Queue {
    int front, rear, size;
    int capacity;
    int[] array;

    public Queue(int capacity) {
       this.capacity = capacity;
       array = new int[capacity];
       size = front = 0;
       rear = -1;
    }

    boolean isFull() {
        return (this.size == this.capacity);
    }

    boolean isEmpty() {
        return (this.size == 0);
    }

    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            this.array[++this.rear] = item;
            this.size++;
            System.out.println(item + " enqueued to queue");
        }

    }

    int dequeue() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        int item = this.array[this.front];
        this.front++;
        return item;
    }

    int front() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return this.array[this.front];
    }

    int rear() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }

    public static void main(String[] args) {
        Queue queue = new Queue(2);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue());
        System.out.println(queue.front());
        System.out.println(queue.isFull());
        System.out.println(queue.rear());

    }
}
