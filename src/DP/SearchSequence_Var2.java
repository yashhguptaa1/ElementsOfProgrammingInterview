package DP;

public class SearchSequence_Var2 {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {

        m=board.length;
        n=board[0].length;

        if(word.length()>m*n)
            return false;

        boolean result=false;
        StringBuilder path=new StringBuilder("");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dfs(i,j,word,board,0,path))
                {
                    System.out.println(path.toString());
                    result=true;
                }
            }
        }
        return result;
    }
    public boolean dfs(int x,int y,String word,char[][] board,int offset,StringBuilder path)
    {
        if(offset==word.length())
            return true;
        if(x<0 || x>=m || y<0 || y>=n)
            return false;

        if(board[x][y]==word.charAt(offset))
        {
            //path.append(word.charAt(offset)).append(" ").append(String.valueOf(x)).append(String.valueOf(y)).append("-->");
            path.append(word.charAt(offset)+" "+String.valueOf(x)+String.valueOf(y)+"--> ");

            char temp=board[x][y];
            board[x][y]='#';

            if(dfs(x+1,y,word,board,offset+1,path)
                    ||dfs(x-1,y,word,board,offset+1,path)
                    ||dfs(x,y+1,word,board,offset+1,path)
                    ||dfs(x,y-1,word,board,offset+1,path) )
                return true;

            board[x][y]=temp;
        }
        return false;
    }
}
