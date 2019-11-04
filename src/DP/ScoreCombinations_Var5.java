package DP;

/*
Define a string t to be an interleaving of strings si and S2 if there is a way to
interleave the characters of and s2, keeping the left-to-right order of each, to obtain
t. For example, if is "gtaa" and s2 is "ate", then "gattaca" and "gtataac" can be
formed by interleaving s2 and s2 but "gatacta" cannot. Design an algorithm that takes
as input strings slr s2 and t, and determines if t is an interleaving of and s2.
 */
public class ScoreCombinations_Var5 {
    public boolean isInterleave(String s1, String s2, String s3) {

        int a=s1.length();
        int b=s2.length();
        int c=s3.length();

        if(a+b!=c)
            return false;

        boolean dp[][]=new boolean[a+1][b+1];
        for(int i=0;i<=a;i++)
        {
            for(int j=0;j<=b;j++)
            {
                if(i==0&&j==0)
                    dp[i][j]=true;

                else if(i==0 && s2.charAt(j-1)==s3.charAt(j-1))
                    dp[i][j]=dp[i][j-1];

                else if(j==0 && s1.charAt(i-1)==s3.charAt(i-1))
                    dp[i][j]=dp[i-1][j];
                else if(i>0 && s1.charAt(i-1)==s3.charAt(i+j-1) && s2.charAt(j-1)!=s3.charAt(i+j-1))
                    dp[i][j]=dp[i-1][j];
                else if(j>0 && s2.charAt(j-1)==s3.charAt(i+j-1) && s1.charAt(i-1)!=s3.charAt(i+j-1))
                    dp[i][j]=dp[i][j-1];
                else if(i>0 && j>0 && s1.charAt(i-1)==s3.charAt(i+j-1) && s2.charAt(j-1)==s3.charAt(i+j-1))
                    dp[i][j]=(dp[i][j-1]||dp[i-1][j]);



            }
        }
        return dp[a][b];
    }
}
