package DP;

/*
A decimal number is a sequence of digits, i.e., a sequence over {0, 1, 2, ... , 9).
The sequence has to be of length 1 or more, and the first element in the sequence
cannot be 0. Call a decimal number D monotone if D[i] < D[i + 1],0 < i < |D|. Write
a program which takes as input a positive integer k and computes the number of
decimal numbers of length k that are monotone.

We can take duplicates, so previously computed values are the one on the left and top .
 */
public class WaystoTraverse_Var5 {

    public static int NumofMonotones(int maxlen)
    {
        int cache[][]=new int [maxlen][9];

        for(int i=0;i<maxlen;i++)
        {
            cache[i][0]=1;

        }
        for(int j=0;j<9;j++)
        {
            cache[0][j]=j+1;
        }

        for(int i=1;i<maxlen;i++)
        {
            for(int j=1;j<9;j++)
            {
                cache[i][j]=cache[i-1][j]+cache[i][j-1];
            }
        }

        return cache[maxlen-1][8];
    }


    public static void main (String[] args)
    {
        System.out.println(NumofMonotones(5));
    }

}
