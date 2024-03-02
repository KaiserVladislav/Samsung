import javax.script.ScriptContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Problems {

    static final int SIZE = 50_000*2;
    static ArrayList<Integer> arrayList = new ArrayList<>(SIZE);
    static LinkedList<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        /*
        creatingAL();
        creatingLL();

        deletingAL();
        deletingLL();

        settingAL();
        settingLL();

        gettingAL();
        gettingLL();
        */

        //System.out.println(check());
/*
        File file = new File("Creation.txt");
        FileWriter fw = new FileWriter(file);
        Scanner sc = new Scanner(System.in);
        System.out.println("INPUT");
        fw.write(sc.nextLine());
        fw.close();
        Scanner another = new Scanner(file);
        char interpretation[] = another.nextLine().toCharArray();
*/
        /*
        Stack<Character> start = new Stack<>();
        Stack<Character> end = new Stack<>();

        for(char c : interpretation){
            start.push(c);
        }
        for(char c : start){
            end.push(c);
        }

        for(char c : end){
            System.out.println(c);
        }*/

        /*
        QueueShendrik queueShendrik = new QueueShendrik();
        for (char c : interpretation)
            queueShendrik.offer(c);
        System.out.println(queueShendrik.pop());
        System.out.println(queueShendrik.pop());
        System.out.println(queueShendrik.pop());
        System.out.println(queueShendrik.pop());
        System.out.println(queueShendrik.pop());
        */

        /*
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

        StackShendrik d = new StackShendrik();
        d.push('1');
        d.push('2');
        d.push('3');

        System.out.println(d.pop());
        System.out.println(d.pop());
        System.out.println(d.pop());*/


        String str = "123";

        int index = new String("123").indexOf(str);

        //System.out.println(index);

        /*
        ArrayList<Integer> sortedARRAY = new ArrayList<>();// assert array as sorted
        for (int i = 0; i < 10; i++) {
            sortedARRAY.add(i);
        }
        System.out.println(binary_search(new int[]{1,2,3,4,5}, 2));
        */
        Problems p = new Problems();
        //System.out.println(Arrays.toString(p.calculateLongestProperSuffix("oboi")));
        p.kmpSearchAlg("oboi","354oboi");

    }
    public void kmpSearchAlg(String word, String text){
        int[] lps = calculateLongestProperSuffix(word);
        int i=0,j =0;
        while(i<text.length()){
            if(word.charAt(j)==text.charAt(i)){
                i++;
                j++;
            }
            if(j==word.length()){
                System.out.println(i-j);
                j=lps[i-1];
            }
            else{
                if(i<text.length() && word.charAt(j)!=text.charAt(i)){
                    if(j!=0){
                        j=lps[i-1];
                    }
                    else {
                        i++;
                    }
                }
            }
        }
    }
    public int[] calculateLongestProperSuffix(String word){
        int len = 0;
        int[] lps = new int[word.length()];

        lps[0]=0;
        for (int i = 1; i < word.length(); i++) {
            if(word.charAt(i)==word.charAt(len)){
                len+=1;
                lps[i]=len;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;

                }
            }
        }
        return lps;
    }


    int binary_search(int target, ArrayList<Integer> arrayList){
        ArrayList<Integer> local = arrayList;
        int med = arrayList.size()/2;

        if(target==arrayList.get(med)){
            return med;
        }

        else if (target<arrayList.get(med)){

        } else{

        }
        return 0;
    }


    static int binary_search(int sequence[], int target){
        ArrayList<Integer> local = arrayList;
        int start = 0;
        int end = sequence.length;

        int med = arrayList.size()/2;

        while (start<=end){
            if(target==sequence[med]){
                return med;
            }
            else{
                if(target<sequence[med]){
                    end=med-1;
                }else{
                    start=med+1;
                }
            }
            if(med!= (start+end)/2){
                med=(start+end)/2;
            }else{
                return -1;
            }

        }
        return -1;
    }




    static boolean check() throws IOException {
        File file = new File("Creation.txt");
        FileWriter fw = new FileWriter(file);
        fw.write(new Scanner(System.in).nextLine());
        fw.close();
        Scanner sc = new Scanner(file);
        Stack<Character> st = new Stack<>();
        String input = sc.nextLine();
        char interpretation[] = input.toCharArray();

        for(char c : interpretation){
            if (c=='{'||c=='('||c=='['){
                st.push(c);
            }
            else{
                if (!st.isEmpty() && (c=='}' && st.peek()=='{') ||
                        (!st.isEmpty() && c==')' && st.peek()=='(') ||
                                (!st.isEmpty() && c==']' && st.peek()=='[')){
                    st.pop();

                }
            }
        }
        return st.isEmpty();
    }

    static void creatingAL(){
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            //arrayList.add(i);
            //arrayList.addFirst(i);
            arrayList.addLast(i);
        }
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
    }

    static void creatingLL(){
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            //linkedList.add(i);
            //linkedList.addFirst(i);
            linkedList.addLast(i);
        }
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
    }

    static void deletingAL(){
        arrayList = new ArrayList<>(100_000);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.removeFirst();
            arrayList.removeLast();
        }
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
    }

    static void deletingLL(){
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.removeFirst();
            linkedList.removeLast();
        }
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
    }

    static void settingAL(){
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            //arrayList.set(i,i);
            arrayList.set(i,i);

        }
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
    }
    static void settingLL(){
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.set(i,i);
        }
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
    }

    static void gettingAL(){
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
    }
    static void gettingLL(){
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
    }
}

class QueueShendrik{
    private Stack<Character> start=new Stack<>();
    private Stack<Character> end=new Stack<>();

    public QueueShendrik(){

    }

    void offer(char c){
        start.push(c);
    }

    char pop(){

        while(!start.isEmpty()){
            end.push(start.pop());
        }

        char output = end.pop();

        while (!end.isEmpty()){
            start.push(end.pop());
        }

        return output;
    }

}

class StackShendrik{
    private Queue<Character> start=new LinkedList<>();
    private Queue<Character> end= new LinkedList<>();
    public StackShendrik(){

    }

    void push(char c){

        end.add(c);

        while (!start.isEmpty()){
            end.add(start.poll());
        }
        Queue<Character> temp = start;
        start=end;
        end=temp;
    }

    char pop(){
        return start.remove();
    }

}
