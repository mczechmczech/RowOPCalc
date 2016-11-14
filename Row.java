import java.util.Scanner;
/**
 * Write a description of class Row here.
 * 
 * @author (Matt Czech) 
 * @version (9-25-15)
 */
public class Row
{
    private Number[] row;
    public Row(int inCols)
    {
        row=new Number[inCols];
    }
    public void changeValue(double inNum, int col)
    {
        row[col].changeValue(inNum);
    }
    public Number getCol(int inCol)
    {
        return row[inCol];
    }
    public void instantiateRow(int inCols)
    {
        System.out.println("---New Row---");
        Scanner sc=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        double inNum;
        int numerator;
        int denominator;
        String isFraction;
        System.out.println("Enter a \"/\" to enter a fraction. Otherwise, press enter.");
        isFraction=sc.nextLine();
        for(int x=0;x<inCols;x++)
        {
            if(isFraction.indexOf("/")!=-1)
            {
                System.out.println("Fraction.");
                System.out.println("Enter a numerator.");
                numerator=sc.nextInt();
                System.out.println("Enter a denominator.");
                denominator=sc.nextInt();
                row[x]=new Number(numerator, denominator);
            }
            else
            {
                System.out.println("Not a fraction.");
                inNum=sc.nextInt();
                row[x]=new Number(inNum);
            }
            System.out.println("Recorded.");
            if(x<inCols-1)
                System.out.println("Enter a \"/\" to enter a fraction. Otherwise, press enter.");
            if(x<inCols-1)
                isFraction=sc2.nextLine();
        }
    }
    public void rowOpAdd(Row inRow, Number inMultiplier)
    {
        for(int x=0;x<row.length;x++)
        {
            row[x].add(inRow.getCol(x), inMultiplier);
        }
    }
    public void rowOpMulti(Number inMultiplier)
    {
        for(int x=0;x<row.length;x++)
        {
            row[x].multiply(inMultiplier);
        }
    }
    public String toString()
    {
        System.out.print("{"+row[0]);
        for(int x=1;x<row.length;x++)
            System.out.print(" , "+row[x]);
        System.out.println("}");
        return "";
    }
}
