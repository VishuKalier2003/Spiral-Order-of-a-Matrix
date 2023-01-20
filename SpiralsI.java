/* Given an m x n matrix, return all elements of the matrix in spiral order...
 * Eg 1: matrix = [[1,2,3],[4,5,6],[7,8,9]]                       Output = [1,2,3,6,9,8,7,4,5]
 * Eg 2: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]              Output = [1,2,3,4,8,12,11,10,9,5,6,7]
 */
import java.util.*;
public class SpiralsI
{
    public List<Integer> SpiralOrder(int matrix[][])
    {
        int row = matrix.length;
        List<Integer> ans = new ArrayList<>();
        if(row<1){      // If there is only one row...
            return ans;
        }
        int col = matrix[0].length;    // Initializing the indices...
        int startR = 0;
        int startCol = 0;
        int i =0;
        
        while(startR<row&& startCol<col){
            for(i= startCol; i< col; ++i){
                ans.add(matrix[startR][i]);    // Moving Left...
            }
            startR++;
            for(i = startR; i<row;++i){
                ans.add(matrix[i][col-1]);     // Moving Down...
            }
            col--;
            if(startR<row){
                for(i = col-1; i>=startCol;--i){
                    ans.add(matrix[row-1][i]);     // Moving Right...
                }
                row--;
            }
            if(startCol<col){
                for(i = row-1; i>=startR;--i){
                    ans.add(matrix[i][startCol]);    // Moving Up...
                }
                startCol++;
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m, n;
        System.out.print("Enter the number of rows (n) : ");
        n = sc.nextInt();
        System.out.print("Enter the number of columns (m) : ");
        m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print("Enter data of "+(i+1)+" row and "+(j+1)+" column : ");
                matrix[i][j] = sc.nextInt();
            }
        }
        SpiralsI spiralsI = new SpiralsI();     // object creation...
        List<Integer> lst = spiralsI.SpiralOrder(matrix);      // Function calling...
        System.out.println("Spirals List : "+lst);
        sc.close();
    }
}

// Time Complexity  - O(n^2) time...
// Space Complexity - O(n) space...