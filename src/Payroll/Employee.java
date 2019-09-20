package Payroll;
/** Our base class for our code that is also abstract and has one abstract method called
 * calculatePay() so that all subclass that extend this one have to invoke the abstract method.
 * Employee also sets or data fields of id,firstName and lastName
 *
 * @author Abdul Liban Programming God
 */
public abstract class Employee
{

   private int id;
   private String firstName;
   private String lastName;

   /**
    *
    * @param id set the id as int
    * @param firstName sets the firstName as String
    * @param lastName sets the lastName as String
    */
   public Employee (int id, String firstName, String lastName)
   {
      this.firstName = firstName;
      this.id = id;
      this.lastName = lastName;
   }


   public int getId ()
   {
      return id;
   }

   /**
    *
    * @param id accpets an int and set the id
    */
   public void setId (int id)
   {
      this.id = id;
   }


   public String getFirstName ()
   {
      return firstName;
   }

   /**
    *
    * @param firstName accepts a String and set the firstName
    */
   public void setFirstName (String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName ()
   {
      return lastName;
   }

   /**
    *
    * @param lastName accpets a String and sets the lastName
    */
   public void setLastName (String lastName)
   {
      this.lastName = lastName;
   }

   /** abstract method so be implemented to all extended classes
    *
    * @return a double
    */
   public abstract double calculatePay ();

   /** Default toString for our Employee info
    *
    * @return a formatted String
    */
   @Override
   public String toString ()
   {
      String format = "Employee %s:  %s %s \n    Salary: $%.2f\n";
      return String.format(format, this.getId(), this.getLastName(), this.getFirstName());
   }

   /** Default toString for our Employee payroll
    *
    * @param num accpets and int to overload the toString method
    * @return a formatted String
    */
   public String toString (int num)
   {
      String format = "Weekly pay for %s, %s employee id %s\n";
      return String.format(format, this.getLastName(), this.getFirstName(), this.getId());
   }
}
