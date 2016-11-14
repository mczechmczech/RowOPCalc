
/**
 * Write a description of class Number here.
 * 
 * @author (Matt Czech) 
 * @version (9-25-15)
 */
public class Number
{
    private double number;
    private int numerator;
    private int denominator;
    private boolean isFract;
    public Number(double inNum)
    {
        number=inNum;
        numerator=(int)inNum;
        denominator=1;
    }
    public Number(int inNumer, int inDenom)
    {
        numerator=inNumer;
        denominator=inDenom;
        if((numerator==0)||(denominator==0))
            number=0;
        number=(numerator*1.0)/(denominator*1.0);
        isFract=true;
    }
    public double value()
    {
        return number;
    }
    public void changeValue(double inNum)
    {
        number=inNum;
    }
    public void multiply(Number inFactor)
    {
        if(inFactor.getDenom()==1)
        {
            number*=inFactor.getNumer();
            numerator*=inFactor.getNumer();
        }
        else
        {
            numerator=numerator*inFactor.getNumer();
            denominator=denominator*inFactor.getDenom();
            number=numerator/denominator;
        }
        if(denominator==1)
            isFract=false;
        if(denominator!=1)
            isFract=true;
        simpleSimplify();
    }
    public void add(Number inNum, Number inMultiplier)
    {
        int subNumer=inNum.getNumer()*inMultiplier.getNumer();
        int subDenom=inNum.getDenom()*inMultiplier.getDenom();
        numerator=(subNumer*denominator)+(numerator*subDenom);
        denominator*=subDenom;
        if(denominator==1)
            isFract=false;
        if(denominator!=1)
            isFract=true;
        simpleSimplify();
    }
    public int getNumer()
    {return numerator;}
    public int getDenom()
    {return denominator;}
    public boolean isFract()
    {return isFract;}
    public String toString()
    {
        if((numerator==0)||(denominator==0))
            return ""+0;
        else if ((numerator==1)&&(denominator==1))
            return ""+numerator;
        else if(denominator==1)
            return ""+numerator;
        return ""+numerator+"/"+denominator;
    }
    public void simpleSimplify()
    {
        for(int x=10;x>1;x--)
        {
            if((this.numerator%x==0) && (this.denominator%x==0))
            {
                numerator/=x;
                denominator/=x;
                x=10;
            }
        }
    }
}
