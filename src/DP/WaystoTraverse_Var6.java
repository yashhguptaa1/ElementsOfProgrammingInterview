package DP;

/*
Call a decimal number D, as defined above, strictly monotone if D[i] < D[i +
i],o<; < |D|. Write a program which takes as input a positive integer k and computes
the number of decimal numbers of length k that are strictly monotone.

The only difference is that now we cannot take duplicates, so previously computed values are the one on the left and left top diagonal.
 */
public class WaystoTraverse_Var6 {

    public static int NumofMonotones(int maxlen)
    {
        int cache[][]=new int [maxlen][9];

        for(int j=0;j<9;j++)
        {
            cache[0][j]=j+1;
        }

        for(int i=1;i<maxlen;i++)
        {
            for(int j=1;j<9;j++)
            {
                cache[i][j]=cache[i][j-1]+cache[i-1][j-1];
            }
        }

        return cache[maxlen-1][8];
    }


    public static void main (String[] args)
    {
        System.out.println(NumofMonotones(5));
    }

}
