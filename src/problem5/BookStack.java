package problem5;

import java.util.LinkedList;

public class BookStack {
    private LinkedList<Book> stack;

    public BookStack() {
        this.stack = new LinkedList<>();
    }

    public void push(Book book) {
        return stack.addFirst(book);
    }

    public Book pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return null;
        }
        return stack.removeFirst();
    }

    public Book peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot peek.");
            return null;
        }
        return stack.getFirst(); 
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("Stack contents (top to bottom):");
        if (isEmpty()) {
            System.out.println("[Empty]");
            return;
        }
        for (Book book : stack) {
            System.out.println(book.toString());
        }
    }
}