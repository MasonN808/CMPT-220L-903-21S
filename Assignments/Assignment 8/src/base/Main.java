package base;

public class Main {
    //linear recursion
    public static int linear_fib(int n){
        if (n<=1) return n;
        else{
            return linear_fib(n-1) + linear_fib(n-2);
        }
    }
    //tail recursion
    public static int tail_fib(int n, int total){
        if(n <= 1){
            return n+total;
        }
        else{
            return tail_fib(n-1, total) + tail_fib(n-2, total);
        }
    }
    //head recursion
    public static int head_fib(int n){
        if (n>1) return head_fib(n-1) + head_fib(n-2);
        else return n;
    }


    public static void main(String[] args) {
        System.out.println(linear_fib(7));
        System.out.println(tail_fib(7, 0));
        System.out.println(head_fib(7));

    }
}
