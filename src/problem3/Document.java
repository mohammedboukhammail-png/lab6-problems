package problem3;

public abstract class Document {
    private static int counter = 1; 
    protected int numRec;
    protected String title;

    public Document(String title) {
        this.numRec = counter++;
        this.title = title;
    }

    public int getNumRec() {
        return numRec;
    }
    public String toString() {
        return "Record #" + numRec + " | Title: " + title;
    }
}