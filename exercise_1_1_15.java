import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
    
public class exercise_1_1_15 {
    public static int[] histogram(int[] a, int M) {
        int[] h = new int[M];
        int N = a.length;
        for(int i = 0; i < N; i++) {
            if(a[i] < M) {
                h[a[i]]++;
            }
        }
        return h;
    }
    
    public static void main(String[] args) {
        
        int N = 100;
        int M = 50;
        
        int[] test_array = new int[N];
        int a_sum = 0;
        for(int i = 0; i < N; i++) {
            test_array[i] = StdRandom.uniform(M);
            a_sum += test_array[i];
        }
        
        int[] h_array = histogram(test_array, M);
        
        int h_sum = 0;
        for (int j = 0; j < M; j++) {
            h_sum += h_array[j];
        }
        
        StdOut.printf("Array a length is: %d.\n", test_array.length);
        StdOut.printf("Array h sum is: %d.\n", h_sum);
    }
}