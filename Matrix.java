
/**
 * Write a description of class Matrix here.
 * 
 * @author (Matt Czech) 
 * @version (9-25-15)
 */
public class Matrix
{
    private Row[] matrix;
    public Matrix(int inRows, int inCols)
    {
        matrix=new Row[inRows];
        for(int x=0;x<matrix.length;x++)
        {
            matrix[x]=new Row(inCols);
            matrix[x].instantiateRow(inCols);
        }
        System.out.println("The matrix has been created. You may perform row operations now.");
    }
    public void rowOpSwitch(int firstRow, int secRow)
    {
        Row holder=matrix[firstRow-1];
        matrix[firstRow-1]=matrix[secRow-1];
        matrix[secRow-1]=holder;
    }
    public Row getRow(int row)
    {
        return matrix[row-1];
    }
    public String toString()
    {
        for(int x=0;x<matrix.length;x++)
        {
            System.out.println(matrix[x]);
        }
        return "";
    }
}
