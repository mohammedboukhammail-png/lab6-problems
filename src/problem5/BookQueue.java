package problem5;

import java.util.LinkedList;

public class BookQueue {
    private LinkedList<Book> queue;

    public BookQueue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(Book book) {
        queue.addLast(book); 

    public Book dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return null;
        }
        return queue.removeFirst(); 
    }

    public Book peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot peek.");
            return null;
        }
        return queue.getFirst(); 
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void display() {
        System.out.println("Queue contents (front to back):");
        if (isEmpty()) {
            System.out.println("[Empty]");
            return;
        }
        for (Book book : queue) {
            System.out.println(book.toString());
        }
    }
}

}