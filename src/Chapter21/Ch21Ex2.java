import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chapter21 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Fibonacci(1));
        Thread t2 = new Thread(new Fibonacci(15));
        Thread t3 = new Thread(new Fibonacci(30));
        Thread t4 = new Thread(new Fibonacci(5));
        Thread t5 = new Thread(new Fibonacci(28));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    private static class Fibonacci implements Runnable {
        private int fbnc;
        private List<Integer> result;

        public Fibonacci(int number) {
            this.fbnc = number;
            result = new ArrayList<>();
        }

        @Override
        public void run() {
            for(int i =0; i< fbnc; i++)
                result.add(fibonacci(i));
            System.out.println(Arrays.toString(result.toArray()));
        }

        private int fibonacci(int number) {

            if (number == 1) {
                return 1;
            }
            if (number == 0) {
                return 0;
            }

            return fibonacci(number-1)+fibonacci(number-2);
        }

    }
}
