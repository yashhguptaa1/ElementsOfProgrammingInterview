package DP;

public class SearchSequence_Var1 {

    int m;
    int n;
    public boolean exist(char[][] board, String word) {

        m=board.length;
        n=board[0].length;

        if(word.length()>m*n)
            return false;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dfs(i,j,word,board,0))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(int x,int y,String word,char[][] board,int offset)
    {
        if(offset==word.length())
            return true;
        if(x<0 || x>=m || y<0 || y>=n)
            return false;

        if(board[x][y]==word.charAt(offset))
        {
            char temp=board[x][y];
            board[x][y]='#';

            if(dfs(x+1,y,word,board,offset+1)
                    ||dfs(x-1,y,word,board,offset+1)
                    ||dfs(x,y+1,word,board,offset+1)
                    ||dfs(x,y-1,word,board,offset+1) )
                return true;

            board[x][y]=temp;
        }
        return false;
    }
}
/*
 Input: [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        "ABCB"

   Output: false
 */