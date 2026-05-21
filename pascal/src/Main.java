/* Liam Waaga */

public class Main {
    
    /* if you can't tell, i am a c++ programmer at heart */
    private static Integer[] __pascalRowSumRecursive_x = {};
    private static int __pascalRowSumRecursive_length = 0;

    /* the "Object n" argument is a sign that horrible things lie beyond */
    public static long pascalRowSumRecursive(Object n) {
        /* let me say, i wrote this code the way i did just to see if i could, not because it is the best way to do it. */
        /* i wanted to have some fun */
        
        if (n instanceof Integer) {
            Integer[] x = new Integer[((Integer)n).intValue() + 1];
            __pascalRowSumRecursive_x = new Integer[((Integer)n).intValue() + 1];
            
            pascalRowSumRecursive(x);
            long sum = 0;
            for (int i = 0; i < x.length - 1; i++) {
                sum += x[i].longValue();
            }
            /* allow the garbage collector to free the memory */
            __pascalRowSumRecursive_x = null;
            return sum;
        } else if (n instanceof Integer[]) {


            /* i have moved all of the local variables here to be private static member variables */
            /* this is all to avoid any memory allocation during the main recursion loop */

            /* calculate the length of the previous row, not the array */
            __pascalRowSumRecursive_length = 0;
            for (int i = 0; i < ((Integer[])n).length && ((Integer[])n)[i] != null; i++) {
                __pascalRowSumRecursive_length++;
            }
            
            if (__pascalRowSumRecursive_length == ((Integer[])n).length - 1) {
                /* in this case, we have actually completed all the calculations. so we may now safely return garbage, and allow the rest of the call stack to deal with itself */
                return -1;
            } else if (__pascalRowSumRecursive_length == 0) {
                /* this is the first row */
                ((Integer[])n)[0] = 1;
            } else {
                /* new row */
                __pascalRowSumRecursive_x[0] = 1;
                __pascalRowSumRecursive_x[__pascalRowSumRecursive_length] = 1;
                for (int i = 1; i < __pascalRowSumRecursive_length; i++) {
                    __pascalRowSumRecursive_x[i] = ((Integer[])n)[i] + ((Integer[])n)[i - 1];
                }
                /* copy every element to the old row so it is passed up the call stack */
                for (int i = 1; i < __pascalRowSumRecursive_length + 1; i++) {
                    ((Integer[])n)[i] = __pascalRowSumRecursive_x[i];
                }
            }

            /* calculate the next row */
            pascalRowSumRecursive(n);

            /* i think unreachable? */
            return -1;
        } else {
            /* unreachable unless we are given some special garbage data */
            return -1;
        }
    }

    public static long pascalRowSumIterative(int n) {
        int[] x = new int[n];
        int[] y = new int[n];
        int[] z;

        for (int i = 0; i < n; i++) {
            /* avoiding memory allocations by using preallocated memory instead */
            y[0] = 1;
            y[i] = 1;
            
            for (int j = 1; j < i; j++) {
                y[j] = x[j] + x[j - 1];
            }

            /* swap references to avoid copying */
            z = x;
            x = y;
            y = z;
        }

        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Method\t\t\t| Input (n)\t| Time (ns)");
        System.out.println("------------------------|---------------|----------");
        for (int i = 5; i < 100; i += 5) {
            long currTime = System.nanoTime();
            pascalRowSumIterative(i);
            long length = System.nanoTime() - currTime;
            System.out.printf("pascalRowSumIterative\t| %d\t\t| %d\n", i, length);
            
            currTime = System.nanoTime();
            pascalRowSumRecursive(i);
            length = System.nanoTime() - currTime;
            System.out.printf("pascalRowSumRecursive\t| %d\t\t| %d\n", i, length);

            
        }
    }
}