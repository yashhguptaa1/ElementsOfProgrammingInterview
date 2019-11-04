package DP;

import java.io.*;
import java.util.*;

/*
Variant: Given A and B as above, compute a longest sequence of characters that is a
subsequence of A and of B. For example, the longest subsequence which is present
in both strings in Figure 17.4 is {r, h, s}.

 */

public class LevenshteinDistance_Var2 {

    static int dp[][];

    public static int longestCommonSubsequence(String text1, String text2,int n,int m) {

        dp =new int[n+1][m+1];

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=0;
                }

                else if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    //
    public static Set<String> printallSubs(String s1,String s2,int n,int m)
    {
        Set<String> AllSubs=new HashSet<>();

        if(n==0 || m==0)
        {
            AllSubs.add("");
            return AllSubs;
        }

        if(s1.charAt(n-1)==s2.charAt(m-1))
        {
            Set<String>rest=printallSubs(s1,s2,n-1,m-1);

            for(String str:rest)
            {
                AllSubs.add(str+s1.charAt(n-1));
            }
        }

        else
        {

            if(dp[n-1][m]>=dp[n][m-1])
                AllSubs=printallSubs(s1,s2,n-1,m);

            if(dp[n][m-1]>=dp[n-1][m])
            {
                Set<String>tmp=printallSubs(s1,s2,n,m-1);

                AllSubs.addAll(tmp);
            }

        }
        return AllSubs;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String text1 = in.readLine();

            String text2 = in.readLine();

            int n=text1.length();
            int m=text2.length();


            int ret = longestCommonSubsequence(text1, text2,n,m);

            System.out.println("LCS length is " +ret);

            Set<String> s = printallSubs(text1, text2, n, m);

            for (String str : s)
                System.out.println(str);

        }
    }
}
/*
OUTPUT
1
carthouse
orchestra
LCS length is 3
che
rhs
rhe
chs
 */