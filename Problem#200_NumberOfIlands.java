public class Solution {
    class Coordinate{
        int x, y;
        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        LinkedList<Coordinate> queue = new LinkedList<Coordinate>();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!visited[i][j] && grid[i][j] == '1'){
                    visited[i][j] = true;
                    ans++;
                    queue.addLast(new Coordinate(i,j));
                    while(!queue.isEmpty()){
                        Coordinate temp = queue.removeFirst();
                        int x = temp.x, y = temp.y;
                        if (x-1 >= 0 && !visited[x-1][y] && grid[x-1][y] == '1'){
                            visited[x-1][y] = true;
                            queue.addLast(new Coordinate(x-1,y));
                        }
                        
                        if (x+1 < n && !visited[x+1][y] && grid[x+1][y] == '1'){
                            visited[x+1][y] = true;
                            queue.addLast(new Coordinate(x+1,y));
                        }
                        
                        if (y-1 >= 0 && !visited[x][y-1] && grid[x][y-1] == '1'){
                            visited[x][y-1] = true;
                            queue.addLast(new Coordinate(x,y-1));
                        }
                        
                        if (y+1 < m && !visited[x][y+1] && grid[x][y+1] == '1'){
                            visited[x][y+1] = true;
                            queue.addLast(new Coordinate(x,y+1));
                        }
                    }
                }
        return ans;
    }
}
