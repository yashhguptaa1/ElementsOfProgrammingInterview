package DP;

public class SearchSequence {
    public boolean exist(char[][] board, String word)
    {

        int m = board.length;
        int n = board[0].length;

        if(word.length()>m*n)
            return false;

        boolean result = false;


        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(dfs(board,word,i,j,0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int k)
    {
        int m = board.length;
        int n = board[0].length;

        if(k==word.length())
        {
            return true;
        }

        if(i<0 || j<0 || i>=m || j>=n )
        {
            return false;
        }
        if(board[i][j] == word.charAt(k))
        {

            if(dfs(board, word, i-1, j, k+1)
                    ||dfs(board, word, i+1, j, k+1)
                    ||dfs(board, word, i, j-1, k+1)
                    ||dfs(board, word, i, j+1, k+1))
            {
                return true;
            }


        }

        return false;
    }
}

/*
 Input: [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        "ABCB"

   Output: true
 */