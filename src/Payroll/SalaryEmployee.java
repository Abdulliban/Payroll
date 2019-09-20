package Payroll;
/** SalaryEmployee extends Employee and calculates pay using the
 * abstract calculatePay() method from the Employee class
 *
 * @author Abdul Liban Programming God
 */
public class SalaryEmployee extends Employee
{
   private double salary;

   /**
    *
    * @param id int value used for employee id
    * @param firstName String value used for first name
    * @param lastName String value used for last name
    * @param salary double used for salary
    */
   public SalaryEmployee (int id, String firstName, String lastName, double salary)
   {

      super(id, firstName, lastName);
      this.salary = salary;
   }

   public double getSalary ()
   {
      return salary;
   }

   /** Calculate pay overrides the abstract method from Employee and calculates pay for
    * salary employee
    *
    * @return a double salaryPay
    */
   @Override
   public double calculatePay ()
   {
      double salaryPay = this.salary / 52;
      return salaryPay;
   }

   /** Overridden toString method to format employee info for salary employee
    *
    * @return a formated String
    */
   @Override
   public String toString ()
   {
      String format = "Employee %s:  %s, %s \n    Salary: $%.2f \n";
      return String.format(format, this.getId(), this.getLastName(), this.getFirstName(), this.getSalary());
   }

   /** Overloaded toString method that accepts an int to format employee info for salary employee
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
