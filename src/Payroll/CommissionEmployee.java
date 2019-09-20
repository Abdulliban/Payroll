package Payroll;
/** CommissionEmployee extends Employee and calculates pay using the
 * abstract calculatePay() method from the Employee class
 *
 * @author Abdul Liban Programming God
 */
public class CommissionEmployee extends Employee
{
   private double rate;
   private double sales;

   /**
    *
    * @param id
    * @param firstName
    * @param lastName
    * @param rate
    * @param sales
    */
   public CommissionEmployee (int id, String firstName, String lastName, double rate, double sales)
   {
      super(id, firstName, lastName);
      this.rate = rate;
      this.sales = sales;
   }


   public double getRate ()
   {
      return rate;
   }


   public double getSales ()
   {
      return sales;
   }

   /** Calculate pay overrides the abstract method from Employee and calculates pay
    * for commission employee
    *
    * @return a double commissionPay
    */
   @Override
   public double calculatePay ()
   {
      double commissionPay = this.sales * this.rate / 100;
      return commissionPay;
   }

   /** Overridden toString method to format employee info for commission employee
    *
    * @return a formated String
    */
   @Override
   public String toString ()
   {
      String format = "Employee %s: %s , %s\n   Commission Rate: $%.1f\n   Sales: $%.2f\n";

      return String.format(format, this.getId(), this.getLastName(), this.getFirstName(), this.getRate(), this.getSales());
   }

   /** Overloaded toString method that accpets an int to format employee payroll for commission employee
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
