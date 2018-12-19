/**
 * The Students class is used to store and process many Student objects.
 * 
 * @author Chris Hopp 
 * @version 12/18/16
 */

import java.util.*;
import java.io.*;
import java.io.IOException;
public class Students
{
   //instance variable for an array of students
   private ArrayList<Student> students;
   
   /**
    * Constructor for an array of students
    */
   public Students(){
       students = new ArrayList<>();
   }
   /**
    * Reads student information from a file and creates a student object to be added to the array
    * of students
    */
   public void readFile() throws IOException{
       
       String fileName = "Students.txt";               
       File file = new File(fileName);
       Scanner fileScanner = new Scanner(file);                  //reads from a file of student data
      
              while(fileScanner.hasNextLine()){
           String name = fileScanner.nextLine();         
           int age = Integer.parseInt(fileScanner.nextLine().trim());
           double gpa = Double.parseDouble(fileScanner.nextLine().trim());

           students.add(new Student(name, age, gpa));           //retrieves student information and creates a new student object
           
       }
       fileScanner.close(); 
   }
   /**
    * Uses a stringbuilder to return a string of student information
    * 
    * @return String of student data separated by newline characters
    */
   public String toString(){
       StringBuilder sb = new StringBuilder();
       for(Student s:students){
           sb.append(s);
           sb.append("\r\n");
           
       }
       return sb.toString();
   }
   /**
    * Prints data of all students to file and to display window
    * 
    * @param PrintWriter to write to file
    */
   public void printData(PrintWriter pw){
       // writes to file
       pw.println("All students in the database");
       pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
       pw.println("\n" + this.toString());
       pw.println();
       
       // writes to display
       System.out.println("All students in the database");
       System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.println(this.toString());

       
   }
   /**
    * Searches student array for student with the highest GPA, saves the location, and writes information
    * to display and to file
    * 
    * @param PrintWriter to write to file
    */
   public void printHigh(PrintWriter pw){
       double gpa = 0.0;
       int index = 0;
       
       for(int i = 0; i < students.size(); ++i){
           if (students.get(i).getGpa() > gpa){
               gpa = students.get(i).getGpa();
               index = i;                           // saves index of student with best gpa  
           }
       }
       
       System.out.println("The student with best GPA is:\n" + students.get(index));    //writes best student to display and file
       pw.println("The student with best GPA is:\r\n" + students.get(index));
       System.out.println();
       pw.println();

   }
   /**
    * Calculates average GPA
    * 
    * @return average GPA
    */
   public double calcAvgGpa(){
       double totalGpa = 0.0;
       for(Student s:students){
           totalGpa += s.getGpa();
       }
       return totalGpa / students.size();                   //returns average GPA
   }
   /**
    * Writes average GPA to display and file
    * 
    * @param PrintWriter to write to file
    */
   public void printAvgGpa(PrintWriter pw){
       double avg = calcAvgGpa();

       System.out.printf("Average GPA: %.2f", avg);           //writes average GPA to display and file
       pw.printf("Average GPA: %.2f \r\n", avg);
       System.out.println();
       pw.println();
   }
   /**
    * Builds an array list of below average students
    * 
    * @return belowAverage an array list of below average students. 
    */
   private ArrayList<Student> belowAverage() {
  
       ArrayList<Student> belowAverage = new ArrayList<Student>(); 
       double avg = calcAvgGpa(); 
       for(int i = 0; i < this.students.size(); i++) {
            if(this.students.get(i).getGpa() < avg)
            belowAverage.add(this.students.get(i));             //checks if GPA is below aveage and adds to array
        }
        return belowAverage;
       
    }
       /**
     * Searches the array of below average students and displays the youngest
     * 
     * @param PrintWriter to write to file
     */
   public void youngestBelowAvg(PrintWriter pw){

      ArrayList<Student> belowAvgStudents = belowAverage(); 

       Student temp = belowAvgStudents.get(0);
       for(int i = 1; i < belowAvgStudents.size(); ++i){
           if (belowAvgStudents.get(i).getAge() < temp.getAge()){           //searches below average array for youngest
               temp = belowAvgStudents.get(i);
           }
       }
       System.out.println("\nThe youngest student with below average GPA is:\n" + temp.toString());
       pw.println("\nThe youngest student below avarage GPA is:\r\n" + temp.toString());
       System.out.println();
       pw.println();                                                    //displays youngest below average
       
   }
}
