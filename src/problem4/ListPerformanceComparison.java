package problem4;

import java.util.*;

public class ListPerformanceComparison {

    private static final int SIZE = 100_000;      
    private static final int OPERATIONS = 10_000;   

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("---- Performance Comparison ----");

        System.out.println("---- Populate both lists ----");
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        testRandomInsertDelete(arrayList, "ArrayList");
        testRandomInsertDelete(linkedList, "LinkedList");
        testSequentialInsertDelete(arrayList, "ArrayList");
        testSequentialInsertDelete(linkedList, "LinkedList");
        testRandomAccess(arrayList, "ArrayList");
        testRandomAccess(linkedList, "LinkedList");
    }

   
    private static void testRandomInsertDelete(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        for (int i = 0; i < OPERATIONS; i++) {
            int index = random.nextInt(list.size());
            list.add(index, i);
            
            int removeIndex = random.nextInt(list.size());
            list.remove(removeIndex);
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random insert/delete: %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

  

    private static void testSequentialInsertDelete(List<Integer> list, String name) {
        long start = System.nanoTime();

  
        if (list instanceof LinkedList) {
            LinkedList<Integer> linkedList = (LinkedList<Integer>) list;
            for (int i = 0; i < OPERATIONS; i++) {
                linkedList.addFirst(i);
                linkedList.addLast(i);
            }
            for (int i = 0; i < OPERATIONS; i++) {
                linkedList.removeFirst();
                linkedList.removeLast();
            }
        } else if (list instanceof ArrayList) {
            ArrayList<Integer> arrayList = (ArrayList<Integer>) list;
            for (int i = 0; i < OPERATIONS; i++) {
                arrayList.add(0, i);
                arrayList.add(i); 
            }
            for (int i = 0; i < OPERATIONS; i++) {
                arrayList.remove(0);
                arrayList.remove(arrayList.size() - 1);
            }
        }

        long end = System.nanoTime();
        System.out.printf("%s - Sequential insert/delete (start/end): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    

    private static void testRandomAccess(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        long sum = 0;
       
        for (int i = 0; i < OPERATIONS; i++) {
            int index = random.nextInt(list.size());
            sum += list.get(index);
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random access (get): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }
}

