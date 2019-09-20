package Payroll;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This program is a simply database program that stores employee information and displays
 * it in 2 different ways. This code includes calculation for payroll for the different types of
 * employee's
 *
 * @author Abdul Liban Programing God
 */
public class Payroll
{
   /**
    * @param args the command line arguments
    */
   public static void main (String[] args)
   {
      //instantiation of the Scanner class as well as the ArrayList class
      final Scanner input = new Scanner(System.in);
      ArrayList<Employee> employee = new ArrayList<>();

      System.out.println("Enter how many employees to create:");

      //numEmployee sets how many employee's are created
      int numEmployee = verifyInt();

      //error handles if they enter a negative
      while (numEmployee < 0) {
         System.out.println("enter positive value");
         numEmployee = verifyInt();
      }

      for (int i = 0; i < numEmployee; i++) {

         //boolean to exit the loop when needed
         boolean exitLoop = true;

         // while loop to prompt users to choose which type of employee each time
         while (exitLoop) {

            exitLoop = false;

            System.out.println("Employee data for " + (i + 1) + " of " + numEmployee);
            System.out.print("Choose type of emplyee to add\n 1. Salaried\n 2. Hourly\n 3. Commission: ");

            //variable for our emplyee options
            int typeOfEmployee = verifyInt();

            switch (typeOfEmployee) {
               case 1:
                  //passing our SalaryEmployee constructor are methods for each arugment 
                  SalaryEmployee salaryEmp = new SalaryEmployee(equalsId(employee, getId()), getFirstName(), getLastName(), getSalary());
                  //adding our instance to our ArrayList
                  employee.add(salaryEmp);
                  break;

               case 2:
                  //passing our HourlyEmployee constructor are methods for each arugment 
                  HourlyEmployee hourEmp = new HourlyEmployee(equalsId(employee, getId()), getFirstName(), getLastName(), getNumHours(), getHourlyRate());
                  //adding our instance to our ArrayList
                  employee.add(hourEmp);
                  break;

               case 3:
                  //passing our CommissionEmployee constructor are methods for each arugment 
                  CommissionEmployee commEmp = new CommissionEmployee(equalsId(employee, getId()), getFirstName(), getLastName(), getCommRate(), getSales());
                  //adding our instance to our ArrayList
                  employee.add(commEmp);
                  break;

               default:
                  //default case so users cant enter a number that us not an option
                  System.out.print("Please enter the correct option");
                  exitLoop = true;
                  break;
            }
         }
      }
      //boolean to exit loop
      boolean exitLoop = true;
      while (exitLoop) {

         //prompts the user for their choice on the second menu
         System.out.print("Choose a Report.\n 1. Employee listing\n 2. Payroll listing\n 3. Exit: ");
         int choice = input.nextInt();

         //switch statement for each option
         switch (choice) {
            case 1:
               //displays employee info and passes it our ArrayList
               displayEmployeeInfo(employee);
               break;
            case 2:
               //displays employee payroll and passes it our ArrayList
               displayEmployeePayroll(employee);
               break;
            case 3:
               exitLoop = false;
            default:
               //prompts user again when correct option isnt chosen
               System.out.println("******Please enter the correct option******\n");
               exitLoop = true;
               break;
         }
      }
   }

   /**
    * displayEmployeeInfo() outputs the toString() method for each of the objects saved
    * inside of the ArrayList
    *
    * @param employees passes and ArrayList of type Employee into the method
    */
   public static void displayEmployeeInfo (ArrayList<Employee> employees)
   {
      for (int i = 0; i < employees.size(); i++) {
         System.out.println(employees.get(i));
      }
   }

   /**
    * displayEmployeePayroll() outputs the Overloaded toString(int num) method in each of
    * subclasses of employee
    *
    * @param employees
    */
   public static void displayEmployeePayroll (ArrayList<Employee> employees)
   {
      for (int i = 0; i < employees.size(); i++) {
         System.out.println(employees.get(i).toString(i));
      }
   }

   /**
    * equalsId() is a method that compares each objects getId() method to the id entered
    *
    * @param employees ArrayList of Employee is being passed
    * @param id an int of the name id is being passed
    * @return an int value that has been checked to see if it is the same as any of our objects
    */
   public static int equalsId (ArrayList<Employee> employees, int id)
   {
      Scanner input = new Scanner(System.in);

      for (int i = 0; i < employees.size(); i++) {
         //while loop to check the id with each of our object's id's in our ArrayList
         while (employees.get(i).getId() == id) {
            System.out.println("ID already exits, please re-enter");
            System.out.print("Employee ID:  ");
            id = input.nextInt();
         }
      }
      return id;
   }

   /**
    * This method error handles so that the user cant enter in a String and prompts
    * them to enter an int again
    *
    * @return an int thats been error handled
    */
   public static int verifyInt ()
   {
      Scanner input = new Scanner(System.in);

      //int error Handling to catch a String
      while (!input.hasNextInt()) {
         System.out.println("Invalid! please use an Int");
         input.nextLine();
      }

      int intVal = input.nextInt();
      return intVal;
   }

   /**
    * Error handles to catch a string and prompts the user to enter a double again
    *
    * @return a double that has been error handled
    */
   public static double verifyDouble ()
   {
      Scanner input = new Scanner(System.in);

      //double error Handling to catch a String
      while (!input.hasNextDouble()) {
         System.out.println("Invalid! please use an Double");
         input.nextLine();
      }

      double doubleVal = input.nextDouble();
      return doubleVal;
   }

   /**
    * This method prompts the user to enter and id and then error handles the entered number
    * with the verifyInt() method and using a while loop to catch a negative value
    *
    * @return an int of id that has been further error handled
    */
   public static int getId ()
   {
      //Scanner input = new Scanner(System.in);
      System.out.print("Enter Empolyee's ID: ");
      int id = verifyInt();

      while (id < 0) {
         System.out.println("Enter a positive value");
         id = verifyInt();

      }
      return id;
   }

   /**
    * This method prompts the user to enter their firstName and returns it
    *
    * @return a String that is returned as firstName
    */
   public static String getFirstName ()
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter Employee's First Name:");
      String firstName = input.nextLine();

      return firstName;

   }

   /**
    * This method Prompts the user to enter the lastName and returns it
    *
    * @return a String that is returned as lastName
    */
   public static String getLastName ()
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter Employee's Last Name:");
      String lastName = input.nextLine();

      return lastName;

   }

   /**
    * This method prompts the user to enter Salary and then error handles it with the
    * verifyDouble() method as well as using a while loop to catch a negative number
    * and then prompt the user again
    *
    * @return a double called salary that has been error handled
    */
   public static double getSalary ()
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter Salary:");
      double salary = verifyDouble();

      while (salary < 0) {
         System.out.println("Enter a positive value");
         salary = verifyDouble();

      }
      return salary;
   }

   /**
    * This method prompts the user to enter numHours and then error handles it with the
    * verifyDouble() method as well as using a while loop to catch a negative number
    * and then prompt the user again
    *
    * @return a double called numHours that has been error handled
    */
   public static double getNumHours ()
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter Hours worked:");
      double numHours = verifyDouble();

      while (numHours < 0) {
         System.out.println("Enter a positive value");
         numHours = verifyDouble();

      }
      return numHours;
   }

   /**
    * This method prompts the user to enter hourly rate and then error handles it with the
    * verifyDouble() method as well as using a while loop to catch a negative number
    * and then prompt the user again
    *
    * @return a double called hourRate that has been error handled
    */
   public static double getHourlyRate ()
   {
      System.out.print("Enter Hourly Rate:");
      double hourRate = verifyDouble();

      while (hourRate < 0) {
         System.out.println("Enter a positive value");
         hourRate = verifyDouble();

      }
      return hourRate;
   }

   /**
    * This method prompts the user to enter commission rate and then error handles it with the
    * verifyDouble() method as well as using a while loop to catch a negative number
    * and then prompt the user again
    *
    * @return a double called commRate that has been error handled
    */
   public static double getCommRate ()
   {
      System.out.print("Enter Commission rate:");
      double commRate = verifyDouble();

      while (commRate < 0) {
         System.out.println("Enter a positive value");
         commRate = verifyDouble();

      }
      return commRate;
   }

   /**
    * This method prompts the user to enter number of sales and then error handles it with the
    * verifyDouble() method as well as using a while loop to catch a negative number
    * and then prompt the user again
    *
    * @return a double called sales that has been error handled
    */
   public static double getSales ()
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter number of Sales:");
      double sales = verifyDouble();

      while (sales < 0) {
         System.out.println("Enter a positive value");
         sales = verifyDouble();

      }
      return sales;
   }
}
