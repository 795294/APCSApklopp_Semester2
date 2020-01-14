package classes;

import java.util.*;

public class IntArrayWorker
{
    /** two dimensional matrix */
    private int[][] matrix = null;

    /** set the matrix to the passed one
     * @param theMatrix the one to use
     */
    public void setMatrix(int[][] theMatrix)
    {
        matrix = theMatrix;
    }

    public int getCount(int val){
        int count = 0;

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c<matrix[r].length; c++){
                if(matrix[r][c] == val){
                    count++;
                }
            }
        }
        return count;
    }

    public int getLargest(){
        int maxValue = matrix[0][0];

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c<matrix[r].length; c++){
                if(matrix[r][c] > maxValue){
                    maxValue = matrix[r][c];
                }
            }
        }

        return maxValue;

    }

    public int getColTotal(int colVal){
        int count = 0;
        for(int i = 0; i<matrix.length; i++){
            count += matrix[i][colVal];
        }

        return count;
    }

    /**
     * Method to return the total 
     * @return the total of the values in the array
     */
    public int getTotal()
    {
        int total = 0;
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix[0].length; col++)
            {
                total = total + matrix[row][col];
            }
        }
        return total;
    }

    /**
     * Method to return the total using a nested for-each loop
     * @return the total of the values in the array
     */
    public int getTotalNested()
    {
        int total = 0;
        for (int[] rowArray : matrix)
        {
            for (int item : rowArray)
            {
                total = total + item;
            }
        }
        return total;
    }

    /**
     * Method to fill with an increasing count
     */
    public void fillCount()
    {
        int numCols = matrix[0].length;
        int count = 1;
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < numCols; col++)
            {
                matrix[row][col] = count;
                count++;
            }
        }
    }

    /**
     * print the values in the array in rows and columns
     */
    public void print()
    {
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix[0].length; col++)
            {
                System.out.print( matrix[row][col] + " " );
            }
            System.out.println();
        }
        System.out.println();
    }

    /** 
     * fill the array with a pattern
     */
    public void fillPattern1()
    {
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix[0].length; 
            col++)
            {
                if (row < col)
                    matrix[row][col] = 1;
                else if (row == col)
                    matrix[row][col] = 2;
                else
                    matrix[row][col] = 3;
            }
        }
    }

    public int[][] loadEvensOdds(int[][] mat){
        int count;
        for(int r = 0; r< mat.length; r++){
            for(int c = 0; c<mat[r].length/2; c++){

                count = (int)((Math.random()*8)+1);

                if(count%2 == 0){
                    mat[r][c] = count;

                    mat[r][mat[r].length-1-c] = count+1;
                } else {
                    mat[r][mat[r].length-1-c] = count;

                    mat[r][c] = count+1;
                }

            }
        }
       
        
        for(int r = 0; r< mat.length; r++){
            for(int c = 0; c<mat[r].length; c++){
                System.out.print(mat[r][c]+",");
            }

            System.out.println();
        }

        return mat;
    }

    public int[][] flipVertical(int[][] mat){
        for(int r = 0; r< mat.length; r++){
            for(int c = 0; c<mat[r].length/2; c++){
                
                int temp = mat[r][c];
                        
                mat[r][c] = mat[r][mat[r].length-1-c];
                        
                mat[r][mat[r].length-1-c] = temp;
                
            }
        }
        
        System.out.println();
        
        
        
        for(int r = 0; r< mat.length; r++){
            for(int c = 0; c<mat[r].length; c++){
                System.out.print(mat[r][c]+",");
            }

            System.out.println();
        }
        
        return mat;
    }

    public static void main(){
        IntArrayWorker arr = new IntArrayWorker();

        int[][] mat = new int[10][10];
       
        
        arr.flipVertical(arr.loadEvensOdds(mat));
    }

}