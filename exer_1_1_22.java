import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class exer_1_1_22
{
    public static int rank(int key, int[] a)   
    {  
        return rank(key, a, 0, a.length - 1, 1);  
    }   
    
    public static int rank(int key, int[] a, int lo, int hi, int depth)   
    {  // Index of key in a[], if present, is not smaller than lo      
       //                                  and not larger than hi.      
        
        StdOut.println(depth + " " + lo + " " + hi);
        if (lo > hi) return -1;      
        int mid = lo + (hi - lo) / 2;      
        if      (key < a[mid]) return rank(key, a, lo, mid - 1, depth + 1);      
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, depth + 1);      
        else                   return mid; 
    }
    
    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);

        Arrays.sort(whitelist);
        
        for (int i = 0; i < whitelist.length; i++)
        {
            StdOut.println(whitelist[i]);
        }

        // read key; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }
}