package Payroll;
/** HourlyEmployee extends Employee and calculates pay using the
 * abstract calculatePay() method from the Employee class
 *
 * @author Abdul Liban Programming God
 */
public class HourlyEmployee extends Employee
{

   private double numHours;
   private double hourlyRate;

   /**
    *
    * @param id
    * @param firstName
    * @param lastName
    * @param numHours
    * @param hourlyRate
    */
   public HourlyEmployee (int id, String firstName, String lastName, double numHours, double hourlyRate)
   {

      super(id, firstName, lastName);
      this.numHours = numHours;
      this.hourlyRate = hourlyRate;
   }


   public double getNumHours ()
   {
      return numHours;
   }


   public double getHourlyRate ()
   {
      return hourlyRate;
   }

   /** Calculate pay overrides the abstract method from Employee that calculates pay for
    * hourlyEmployee
    *
    * @return a double hourlyPay
    */
   @Override
   public double calculatePay ()
   {
      double hourlyPay = numHours * hourlyRate;
      return hourlyPay;
   }

   /** Overridden toString method to format employee info for hourly employee
    *
    * @return a formated String
    */

   @Override
   public String toString ()
   {
      String format = "Employee %s: %s , %s\n   Hours: %.1f\n   Rate: $%.2f\n";

      return String.format(format, this.getId(), this.getLastName(), this.getFirstName(), this.getNumHours(), this.getHourlyRate());
   }

   /** Overloaded toString method that accepts an int to format employee payroll for hourly employee
    *
    * @param num int argument used to overload the toString method
    * @return a formated String
    */
   @Override
   public String toString (int num)
   {
      String format = "Weekly pay for %s, %s employee id %s is $%.2f\n";
      return String.format(format, this.getLastName(), this.getFirstName(), this.getId(), this.calculatePay());
   }


}
