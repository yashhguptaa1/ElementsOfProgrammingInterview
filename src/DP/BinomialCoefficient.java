package DP;

import java.util.Scanner;

public class BinomialCoefficient {

    public static int ncr(int n,int r)
    {
        int dp[][]=new int[n+1][r+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=Math.min(i,r);j++)
            {
                // for case n=4 , r=2
                // u dont need to calculate 3C3 as r<=2
                //that is why we take min
                if(j==0 || i==j)
                    dp[i][j]=1;

                else
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
        return dp[n][r];
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();
        while(t-- >0)
        {
            int n=sc.nextInt();
            int r=sc.nextInt();
            System.out.println(ncr(n,r));
        }



    }
}
