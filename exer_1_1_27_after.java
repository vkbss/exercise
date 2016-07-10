import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Counter;

public class exer_1_1_27_after
{    
    public static double binomial(int N, int k, double p, Counter c)
    {
        double[][] v = new double[N+1][k+1];
        for(int i = 0; i < N + 1; i++)
            for(int j = 0; j < k + 1; j++)
            v[i][j] = -1;
        
        return binomial(N, k, p, c, v);
    }
    
    public static double binomial(int N, int k, double p, Counter c, double[][] v)
    {
        c.increment();
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        if(v[N][k] == -1)
        {
            v[N][k] = (1.0 - p)*binomial(N-1, k, p, c, v) + p*binomial(N-1, k-1, p, c, v);
        }
        return v[N][k];
    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]),
            k = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        
        Counter c = new Counter("calls");
        
        double b = binomial(n, k, p, c);
        
        StdOut.println(b);
        StdOut.println(c);
    }
}
