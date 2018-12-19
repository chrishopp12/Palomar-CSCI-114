import java.util.Scanner;

/**
 * Tests Circles.
 * 
 * @author Chris Hopp 
 * @version 9/25/16
 */
public class CircleTester
{
    public static void main(String[] args)
    {
        System.out.print("\f");
        
        Scanner in = new Scanner(System.in);            //creates input scanner
        
        
        System.out.println("Enter circle radius: ");    //input radius
        double radius = in.nextDouble();
        
        System.out.println("Enter circle color: ");     //input color
        String color = in.next();
        
        Circle test = new Circle (radius, color);       //circle created from input
        
        
        System.out.println("Your circle details: ");
        System.out.println("Color: " + test.getColor()); //displays color
        
        double circumference = test.calcCircumference(); //displays circumference
        System.out.printf("Circumference: %.2f \n", circumference);
        
        double area = test.calcArea();
        System.out.printf("Area: %.2f",area);            //displays area
        


    }
}