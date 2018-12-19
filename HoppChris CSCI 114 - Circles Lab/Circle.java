/**
 * Circle class returns color, computes and returns circuference and area.
 * 
 * @author Chris Hopp
 * @version 9/25/16
 */
public class Circle
{
    // Variables for radius and color.  Value of pi set
    private static final double PI = 3.1415926;
    private double radius;
    private String color;



    public Circle(double rad, String col)
    {   //constructor sets radius to input
        radius = rad;
        color = col;

    }
    
    public double calcCircumference ()
    {   //method to compute circumference
        double circumference = 2 * PI * radius;
        return circumference;
    }
    
    public double calcArea()
    {   //method to compute area
        double area = radius * radius * PI;
        return area;
    }
    
    public String getColor()
    {   //method to return color
        return color;
    }
}