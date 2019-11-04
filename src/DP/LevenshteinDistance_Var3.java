package DP;



/*
Variant: Given a string A, compute the minimum number of characters you need to
delete from A to make the resulting string a palindrome.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class LevenshteinDistance_Var3 {
    public static int minDelPali(String s1)
    {
        StringBuffer tmp=new StringBuffer(s1);
        String s2=(tmp.reverse()).toString();

        int n=s1.length();

        //System.out.println(s2);
        int ld[][]=new int[n+1][n+1];
        for(int row[]:ld)
        {
            Arrays.fill(row,-1);
        }

        getLevDist(s1,n,s2,n,ld);

        int res=Integer.MAX_VALUE;
        int i=n;
        int j=0;

        while(i>=0)
        {
            res=Math.min(res,ld[i][j]);
            if(i<n)
            {
                res=Math.min(res,ld[i+1][j]);
            }
            if(i>0)
            {
                res=Math.min(res,ld[i-1][j]);

            }
            i--;
            j++;

        }


        return res;
    }

    public static void getLevDist(String a,int m,String b,int n,int ld[][])
    {
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if(i==0)
                    ld[i][j]=j;

                else if(j==0)
                    ld[i][j]=i;

                else if(a.charAt(i-1)==b.charAt(j-1))
                    ld[i][j]=ld[i-1][j-1];

                else
                    ld[i][j]=1+Math.min(ld[i-1][j],ld[i][j-1]);
            }
        }

        return ;
    }
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(in.readLine().trim());

        while(t-->0)
        {
            String inp=in.readLine();
            System.out.println(minDelPali(inp));
        }
    }
}