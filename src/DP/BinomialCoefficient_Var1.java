package DP;

public class BinomialCoefficient_Var1 {


    public static int ncr(int n,int r)
    {
        int C[]=new int[r+1];

        C[0]=1;

        for(int i=1;i<=n;i++)
        {
            for(int j=Math.min(i,r);j>0;j--)
            {
                C[j]=C[j]+C[j-1];

            }

        }

        return C[r];
    }
    public static void main(String[] args)
    {
        int n = 5, k = 2;
        System.out.printf("Value of C(%d, %d) is %d "
                , n, k, ncr(n, k));
    }
}
