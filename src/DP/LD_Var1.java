package DP;

public class LD_Var1 {


}
// A Dynamic Programming based Java program to find minimum
// number operations to convert str1 to str2
class EDIST
{
    static int min(int x,int y,int z)
    {
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z) return y;
        else return z;
    }

    static int editDistDP(String str1, String str2, int m, int n)
    {
        // Create a table to store results of subproblems
        int dp[][] = new int[2][n+1];

        for(int v=0;v<=n;v++)
        {
            dp[0][v] = v; // Min. operations = j
        }

        // Fill d[][] in bottom up manner
        for (int i=1; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                // If first string is empty, only option is to
                // insert all characters of second string

                // If second string is empty, only option is to
                // remove all characters of second string
                if (j==0)
                    dp[1][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[1][j] = dp[0][j-1];

                    // If the last character is different, consider all
                    // possibilities and find the minimum
                else
                    dp[1][j] = 1 + min(dp[1][j-1], // Insert
                            dp[0][j], // Remove
                            dp[0][j-1]); // Replace
            }
            if(i>=1)
            {
                for (int j=0; j<=n; j++)
                {
                    dp[0][j]=dp[1][j];
                }

            }
        }

        for (int i=0; i<2; i++)
        {
            for (int j=0; j<=n; j++)
            {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }



        return dp[1][n];
    }



    public static void main(String args[])
    {
        String str1 = "sunday";// should be the smllest of two
        String str2 = "saturday";//should be the longest string of two
        System.out.println( editDistDP( str1 , str2 , str1.length(), str2.length()) );
    }
}/*This code is contributed by Rajat Mishra*/
