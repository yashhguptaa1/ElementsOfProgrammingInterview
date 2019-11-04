package DP;

import java.util.Scanner;

public class ScoreCombinations_Var2 {

    public static int numofComb(int tot)
    {
        int scores[]={2,3,7};
        int dp[]=new int[tot+1];

        dp[0]=1;
        dp[1]=0;
        dp[2]=1;
        dp[3]=1;

        for(int i=4;i<=tot;i++)
        {
            int sum=0;
            for(int j=0;j<3;j++)
            {
                if(scores[j]<=i)
                {
                    sum+=dp[i-scores[j]];
                }
                dp[i]=sum;
            }
        }
        return dp[tot];
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int totalscore=sc.nextInt();

        System.out.println(numofComb(totalscore));

    }

}
