package problem3;

import java.util.ArrayList;

public class Library {
    private int capacity;
    private ArrayList<Document> documents;

    public Library(int capacity) {
        this.capacity = capacity;
        this.documents = new ArrayList<>();
    }

    public void displayDocuments() {
        if (documents.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        for (Document doc : documents) {
            System.out.println(doc.toString());
        }
    }

    public boolean add(Document doc) {
        if (documents.size() < capacity) {
            documents.add(doc);
            return true;
        }
        System.out.println("Library is full! Cannot add: " + doc.title);
        return false;
    }

    public boolean delete(Document doc) {
        return documents.remove(doc);
    }

    public Document document(int numEnrg) {
        for (Document doc : documents) {
            if (doc.getNumRec() == numEnrg) {
                return doc;
            }
        }
        return null;
    }

    public void displayAuthors() {
        System.out.println("--- List of Authors ---");
        for (Document doc : documents) {
            if (doc instanceof Book) {

                Book book = (Book) doc; 
                System.out.println("- " + book.getAuthor());
            }
        }
    }
}