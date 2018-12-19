
/**
 * Car class computes range and gallons of gas.
 * 
 * @author Chris Hopp
 * @version 9/18/16
 */
public class Car
{
    // Variables for miles per gallon and gallons in tank.
    private double milesPerGallon;
    private double gallonsInTank;


    public Car(double mpg)
    {   //constructor sets miles per gallon to inputted value and gallons in tank to 3.5
        milesPerGallon = mpg;
        gallonsInTank = 3.5;
    }
    
    public void addGas(double gas)
    {   //method to compute gallons in tank after adding gas
        gallonsInTank = (gallonsInTank + gas);
    }
    
    public void drive(double miles)
    {   //method to compute gallons in tank after miles driven
        double gasUsed = (miles/ milesPerGallon);
        gallonsInTank = (gallonsInTank - gasUsed);
    }
    
    public double range()
    {   //method to compute and return range remaining from gas in tank and miles per gallon
        double rangeRemaining = (milesPerGallon * gallonsInTank);
        return rangeRemaining;
    }
}