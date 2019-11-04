package Recursion;

import java.util.*;
public class ToH {


    public static void toh(int n,int src,int dest,int helper,ArrayList<ArrayList<Integer>> mv)
    {
        if(n>0)
        {
            //toh(n-1,src,helper,dest,mv);
            ArrayList<Integer> tmp=new ArrayList<Integer> ();
            tmp.add(src);
            tmp.add(dest);
            mv.add(tmp);
            toh(n-1,helper,dest,src,mv);
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t -- >0)
        {
            ArrayList<ArrayList<Integer>> movements = new ArrayList<ArrayList<Integer> >();
            int rings=sc.nextInt();
            //int movenum=sc.nextInt();
            toh(rings,1,3,2,movements);
            //System.out.println((movements.get(movenum-1)).get(0)+" "+(movements.get(movenum-1)).get(1));
            System.out.println(movements.size());
            System.out.println(movements);


        }
        //code
    }

}
