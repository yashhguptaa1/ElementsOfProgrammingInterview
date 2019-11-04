package DP;

/*
A fisherman is in a rectangular sea. The value of the fish at point (i, j) in the
sea is specified by an n X m 2D array A. Write a program that computes the maximum
value of fish a fisherman can catch on a path from the upper leftmost point to the
lower rightmost point.
 */
public class WaystoTraverse_Var3 {

    public int maxPathSum(int[][] grid) {

        int m=grid.length;
        if(m==0)
            return 0;
        int n=grid[0].length;
        int cost[][]=new int [m][n];
        cost[0][0]=grid[0][0];// base case

        for(int i=1;i<m;i++)
        {
            cost[i][0]=cost[i-1][0]+grid[i][0];
        }

        for(int j=1;j<n;j++)
        {
            cost[0][j]=cost[0][j-1]+grid[0][j];
        }

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {

                cost[i][j]=grid[i][j]+Math.max(cost[i-1][j],cost[i][j-1]);
            }
        }

        int i=m-1;
        int j=n-1;

        while(i>0 && j>0)
        {

            System.out.print("("+i+","+j+")->");

            if(cost[i-1][j]>cost[i][j-1])
            {
                i--;
            }
            else if(cost[i-1][j]<cost[i][j-1])
                j--;

        }
        return cost[m-1][n-1];
    }


}
