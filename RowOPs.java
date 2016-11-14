import java.util.Scanner;
/**
 * Write a description of class RowOPs here.
 * 
 * @author (Matt Czech) 
 * @version (9-25-15)
 */
public class RowOPs
{
    
    Scanner sc=new Scanner(System.in);
    public RowOPs()
    {
        
    }
    
    public static void main(String[] args)
    {
        Matrix mx;
        Scanner sc=new Scanner(System.in);
        String go="y";
        boolean loop=true;
        int rows;
        int cols;
        int op;
        int rowOne;
        int rowTwo;
        int numerator=-1;
        int denominator=-1;
        double multi=0.0;
        Number multiplier;
        String isFraction;
        
        System.out.println("How many rows does the matrix have?");
        rows=sc.nextInt();
        System.out.println("How many cols does the matrix have?");
        cols=sc.nextInt();
        mx=new Matrix(rows,cols);
        while(loop)
        {
            System.out.println(mx);
            System.out.println("Enter 1 to add a row to another row by a multiplier.");
            System.out.println("Enter 2 to multiply a row by a number.");
            System.out.println("Enter 3 to switch the row positions of two rows.");
            System.out.println("Enter 4 to reset the matrix to its original status.");
            op=sc.nextInt();
            //add a row to another row multiplied by a number
            if(op==1)
            {
                System.out.println("Enter the row number you would like to change, followed by the enter key.");
                rowOne=sc.nextInt();
                System.out.println("Enter the row number you would like to add to a row, followed by the enter key.");
                rowTwo=sc.nextInt();
                System.out.println("Enter a \"/\" to enter a fraction. Otherwise, press enter.");
                isFraction=sc.nextLine();
                isFraction=sc.nextLine();
                if(isFraction.indexOf("/")!=-1)
                {
                    System.out.println("Fraction.");
                    System.out.println("Enter a numerator.");
                    numerator=sc.nextInt();
                    System.out.println("Enter a denominator.");
                    denominator=sc.nextInt();
                    multiplier=new Number(numerator, denominator);
                }
                else
                {
                    System.out.println("Not a fraction.");
                    multi=sc.nextDouble();
                    multiplier=new Number(multi);
                }
                
                mx.getRow(rowOne).rowOpAdd(mx.getRow(rowTwo),multiplier);
                if((numerator==-1)&&(denominator==-1))
                {
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("\t\t\tR"+rowOne+" <-- "+multiplier.value()+"R"+rowTwo+" + R"+rowOne);
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                }
                else
                {
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("\t\t\tR"+rowOne+" <-- "+multiplier.getNumer()+"/"+multiplier.getDenom()+"R"+rowTwo+" + R"+rowOne);
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                }
            }
            //multiply a row by a number
            if(op==2)
            {
                System.out.println("Enter the row number you would like to change, followed by the enter key.");
                rowOne=sc.nextInt();
                System.out.println("Press enter before entering a number for the row to be multiplied by, or enter \"/\" to enter a fraction.");
                isFraction=sc.nextLine();
                isFraction=sc.nextLine();
                if(isFraction.indexOf("/")!=-1)
                {
                    System.out.println("Fraction.");
                    System.out.println("Enter a numerator.");
                    numerator=sc.nextInt();
                    System.out.println("Enter a denominator.");
                    denominator=sc.nextInt();
                    multiplier=new Number(numerator, denominator);
                }
                else
                {
                    multi=sc.nextDouble();
                    multiplier=new Number(multi);
                }
                
                mx.getRow(rowOne).rowOpMulti(multiplier);
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("\t\t\tR"+rowOne+" <-- "+multiplier.value()+"R"+rowOne);
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            }
            //switch two rows
            if(op==3)
            {
                System.out.println("Enter the row number you would like to be switched, followed by the enter key.");
                rowOne=sc.nextInt();
                System.out.println("Enter the other row number you would like to add to be switched, followed by the enter key.");
                rowTwo=sc.nextInt();
                
                mx.rowOpSwitch(rowOne, rowTwo);
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("\t\t\tR"+rowOne+" <--> R"+rowTwo);
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            }
            System.out.println(mx);
            //loop breaker
            System.out.println("Keep performing row ops?(y/n)");
            go=sc.nextLine();
            go=sc.nextLine();
            if(go.equals("n"))
                loop=false;
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
    }
}
