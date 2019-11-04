package DP;

import java.util.*;
/*
Write a program that takes two strings and computes the minimum number of edits
needed to transform the first string into the second string.
 */
public class LevenshteinDistance {

    public static int minDistance(String word1, String word2) {

        int m=word1.length();
        int n=word2.length();
        int ld[][]=new int[m][n];
        for(int row[]:ld)
        {
            Arrays.fill(row,-1);
        }

        return getLevDist(word1,m-1,word2,n-1,ld);
    }

    public static int getLevDist(String a,int aind,String b,int bind,int ld[][])
    {
        if(aind<0)
            return bind+1;

        else if(bind<0)
            return aind+1;

        if(ld[aind][bind]==-1)
        {
            if(a.charAt(aind)==b.charAt(bind))
            {
                ld[aind][bind]=getLevDist(a,aind-1,b,bind-1,ld);
            }
            else

            {
                int subsLast=getLevDist(a,aind-1,b,bind-1,ld);

                int delLast=getLevDist(a,aind-1,b,bind,ld);

                int addLast=getLevDist(a,aind,b,bind-1,ld);

                ld[aind][bind]=1+Math.min(subsLast,Math.min(delLast,addLast));


            }
        }
        return ld[aind][bind];
    }

}
