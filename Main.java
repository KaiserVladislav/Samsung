import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * ARTEM (?)
 *
 * Structures and algorithms:
 * [to store and to work with data]
 * Arraylist[sigma]; LinkedList[based]; Stack [gross]; Queue[grotesque]; Deque [cringe]
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("Creation.txt");
        FileWriter fw =new FileWriter(file);
        fw.write("HI!");
        fw.close();

        ArrayList<Integer> example_AL = new ArrayList<>(10);// dynamic memory allocation
        Integer example_A[] = new Integer[10]; // static memory allocation
        //add vs set
        example_AL.add(0);
        example_A[0]=0;
        //get
        example_AL.get(0);
        int a = example_A[0];

        example_AL.remove(0);
        //int b = example_AL.remove(3);

        // pros : just like in arrays in general (fast accessing and search)
        // cons : just like in arrays lmao (slow add/delete)

        LinkedList<Integer> example_LL = new LinkedList<>();

        example_LL.add(2);/*
        for(Integer c : example_LL){
            System.out.println(c);
        }*/

        // pros : fast add/delete
        // cons : slow accessing and search

        Stack<Integer> example_ST=new Stack<>();
        example_ST.push(1);
        example_ST.push(2);
        example_ST.push(3);
        //System.out.println(example_ST.pop());
        //System.out.println(example_ST.pop());
        //System.out.println(example_ST.pop());
        //int peek  = example_ST.peek();
        //System.out.println(peek);


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
/*
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
*/

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(2);
        deque.offerFirst(1);
        deque.offerLast(3);
        System.out.println( deque.poll());
        System.out.println( deque.poll());
        System.out.println( deque.poll());



    }

}
