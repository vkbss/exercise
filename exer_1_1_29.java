import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class exer_1_1_29
{
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else 
            {
                while (--mid > 0 && a[mid] == key);
                return mid + 1;
            }
        }
        return -1;
    }
    
    public static int count(int key, int[] a)
    {
        int c = 1;
        int i = rank(key, a);
        while (++i < a.length && a[i] == key) c++;
        return c;
    }
    
    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if (rank(key, whitelist) >= 0)
            {
                StdOut.println(count(key, whitelist));
            }
            /*if (rank(key, whitelist) < 0)
                StdOut.println(key);
                */
        }
    }
}