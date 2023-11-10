//TODO: primitive data types, arithmetical operands and operations;
// conditional expressions, loops, arrays basics, ArrayList<>
// alexander igorevich

import java.util.*;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class Main {
    static String classifiy(){
        int a = new Scanner(System.in).nextInt();
        return (a<=9) ? "DIGIT" : (a<=99 ? "NUM" : "OTHER");

    }
    static void compare(){
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
        int c = new Scanner(System.in).nextInt();

        if (a>=b && a>=c){
            if(b>c)
                System.out.println(c+""+b+""+a);
            else
                System.out.println(b+""+c+""+a);
        }
        else if(b>=a && b>=c){
            if(a>c)
                System.out.println(c+""+a+""+b);
            else
                System.out.println(a+""+c+""+b);
        }
        //////// useless code
    }

    static int sum(int arg1, int arg2){
        return arg1+arg2;
    }

    static int last_digit(int argument){
        return argument%10;
    }

    static int digits_sum(int arg){
        return (arg/100)%10 + (arg/10)%10 +(arg)%10;
    }

    static int next_even(int argument){
        return argument+argument%2;
    }
    static void pies(){
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
        int n = new Scanner(System.in).nextInt();
        int res = a*n + b*n/100;
        b =  b*n%100;
        System.out.println(res+ " " + b);
    }
    static void clockworks(){
        int secs = new Scanner(System.in).nextInt();

        int res = secs / 3600;
        int res1 = (secs-res*3600) / 60;
        int res2 = (secs-res*3600-res1*60);
        //System.out.println(res + ":" + String.format(res1,".dd" ) + ":" + res2);
        System.out.println(String.format("%d:%d:%d",res,res1,res2));

    }

    static void diagonale(){
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
        System.out.println(String.format("%.2f",Math.sqrt(a*a-b*b)));

    }
    static void power_two(){
        int a = 1;
        int b = new Scanner(System.in).nextInt();
        System.out.println(a<<b);
    }
    static void insert_1(){
        int a = new Scanner(System.in).nextInt();
        int i = new Scanner(System.in).nextInt();

        //String S = Integer.toBinaryString(a);
        //StringBuilder stringBuilder = new StringBuilder(S);
        //stringBuilder.insert(i,"1");

    }
    public static void main(String[] args) {

//        System.out.println("First num is");
//        int arg1 = new Scanner(System.in).nextInt();
//        System.out.println("Second num is");
//        int arg2 = new Scanner(System.in).nextInt();
//        System.out.println("Sum is " + sum(arg1,arg2));

        //System.out.println("s is "+ digits_sum(num));
        //System.out.println("Last digit is " + last_digit(num));
        //clockworks();
        //diagonale();

//        int a = -5;
//        int b = 7;
//        System.out.println(a + " " + b); // swapping
//        System.out.println(a&b); // and
//        System.out.println(a|b); // or
//        System.out.println(~a); // not
//        System.out.println(a^b); // xor
//        System.out.println(a<<1);
//        System.out.println(a>>1);
//        int num = a >> 1;
//        System.out.println("\n");
//        System.out.println(num);
//        System.out.println(Integer.toBinaryString(num));

//        int[] nulls = new int[1000*1000];
//        Arrays.fill(nulls,0);
//        ArrayList<Integer> ar = new ArrayList<>();
//        ar.add(1);
//        ar.get(0);


       // System.out.println(classifiy());
//        int a = new Scanner(System.in).nextInt();
//        int c = 1;
//        while(a >=0){
//            a= new Scanner(System.in).nextInt();
//            c++;
//        }
//        System.out.println(c);

//        int a= new Scanner(System.in).nextInt();
//        int b= new Scanner(System.in).nextInt();
//        int res = 0;
//        while (a-b>=0){
//            res++;
//            a-=b;
//
//        }
//
//        System.out.println(res + " " + a);
//

//        int n = new Scanner(System.in).nextInt();
//        int arra[] = new int[n];
//        for (int i = 1; i <= n; i++){
//            arra[i-1]= new Scanner(System.in).nextInt();
//        }
//        System.out.println("X is");
//        int x = new Scanner(System.in).nextInt();
//        int t = 0;
//        for (int i = 0; i<arra.length;i++){
//            t++;
//            if (arra[i]==x){
//                System.out.println(i+1);
//                break;
//            }
//            if (t==x)
//                System.out.println("NO");
//
//        }


        int n = new Scanner(System.in).nextInt();
        int arra[] = new int[n];
        for (int i = 0; i < n; i++){
           arra[i]= new Scanner(System.in).nextInt();
        }

        for (int i = 0; i < arra.length; i++){
            arra[i] = arra[i] ^ arra[arra.length-1-i];
            arra[arra.length-1-i] = arra[i];
            arra[i] = arra[i] ^ arra[arra.length-1-i];
            System.out.println(arra[i]);
        }



    }
}
