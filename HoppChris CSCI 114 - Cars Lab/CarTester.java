/**
 * Tests Cars.
 * 
 * @author Anthony W. Smith 
 * @version 5/31/2028
 */
public class CarTester
{
    /**
     * main() method
     */
    public static void main(String[] args)
    {
        Car honda = new Car(30.0);      // 30 miles per gallon
        
        honda.addGas(9.0);              // add 9 more gallons
        honda.drive(210.0);             // drive 210 miles
        
        // print range remaining
        System.out.println("Honda range remaining: " + honda.range());

        Car toyota = new Car(26.0);      // 26 miles per gallon
        
        toyota.drive(60.0);              // drive 60 miles
        toyota.addGas(4.5);              // add 4.5 more gallons
        
        // print range remaining
        System.out.println("Toyota range remaining: " + toyota.range());
    }
}