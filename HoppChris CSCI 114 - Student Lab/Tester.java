/**
 * The Tester class is used to test student and students classes
 * 
 * @author Chris Hopp 
 * @version 12/18/16
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class Tester
{
    public static void main(String [] args) throws IOException{
        
        PrintWriter printWriter = new PrintWriter(new File("output.txt")); // Creates PrintWriter to output.txt file
        Students students = new Students();                                
        students.readFile();                                               // Creates students from data file
        students.printData(printWriter);                                   // Displays all student data
        students.printHigh(printWriter);                                   // Displays student with the highest GPA
        students.printAvgGpa(printWriter);                                 // Displays average GPA
        students.youngestBelowAvg(printWriter);                            // Displays youngest student with GPA below avg
        printWriter.close();                                               // Closes file 
    }
}
