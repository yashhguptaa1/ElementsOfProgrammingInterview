package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaystoTraverse {


    public static int uniquePaths(int m, int n) {
        int cache[][]=new int[m][n];
        return traverse(m-1,n-1,cache);

    }
    public static int traverse(int x,int y,int cache[][])
    {
        if(x==0 || y==0)
            return 1;

        if(cache[x][y]==0)
        {
            int waystotop=(x==0)?0:traverse(x-1,y,cache);

            int waystoleft=(y==0)?0:traverse(x,y-1,cache);

            cache[x][y]=waystotop+waystoleft;

        }

        return cache[x][y];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            int ret = uniquePaths(m, n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}