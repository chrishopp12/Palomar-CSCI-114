/**
 * The Student class tracks the information of one student
 * 
 * @author Chris Hopp
 * @version 12/18/16
 */
public class Student
{
   //instance variables
   private String name;
   private int age;
   private double gpa; 
   
  /**
   * Constructor for an individual student
   */
   public Student(String name, int age, double gpa){
       this.name = name;
       this.age = age;
       this.gpa = gpa;
   }
   /**
    * Formats and returns students information in string format
    * @return - String with the name, age, and gpa of student
    */
   public String toString(){
       String info = String.format("%-10s %6d %8.2f", name, age, gpa);
       return info;
   }
   /**
    * @return name;
    */
   public String getName(){
       return name;
   }
   /** 
    * @return age
    */
   public int getAge(){
       return age;
   }
   /** 
    * @return gpa
    */
   public double getGpa(){
       return gpa;
   }   
}
