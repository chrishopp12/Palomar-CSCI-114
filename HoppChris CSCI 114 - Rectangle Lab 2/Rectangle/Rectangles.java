import java.awt.Rectangle;

/**
 * CSCI 114 online, Week 2 Rectangles homework
 * 
 * @author Chris Hopp
 * @version 9/4/2016
 */
public class Rectangles
{
    public static void main(String[] args)
    {
        // Create some rectangle objects
        Rectangle rectangle1 = new Rectangle(0, 0, 10, 20);
        Rectangle rectangle2 = new Rectangle(5, 10, 20, 10);
        
        System.out.println("rectangle1 is: " + rectangle1.toString());
        System.out.println("rectangle2 is: " + rectangle2.toString());
        
        // Intersecting rectangles
        Rectangle rectangleIntersection = rectangle1.intersection(rectangle2);
        
        System.out.println("Intersection is: " + rectangleIntersection.toString());
        
        // Empty rectangles
        Rectangle anotherRectangle = new Rectangle(100, 200, 10, 10);
        Rectangle emptyIntersection = rectangle1.intersection(anotherRectangle);
        System.out.println("Empty rectangle is:" + emptyIntersection.toString());
        
        // Confirm rectangle is empty
        System.out.println("Empty rectangle contains rectangle1:" + emptyIntersection.contains (rectangle1));
        System.out.println("Empty rectangle contains rectangle2:" + emptyIntersection.contains (rectangle2));


       
    }
}
