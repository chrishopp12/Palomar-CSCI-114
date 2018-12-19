/**
 * MoneyMarket subclass of superclass checking creates a money market account that can be manipulated with the checking superclass methods.  Checks for minimum balance requirements.
 * 
 * @author Chris Hopp 
 * @version 12/4/2016
 */
public class MoneyMarket extends Checking
{
    //static constants for set fee amounts
    private static final int minBalance = 50000;
    private static final int minBalanceFee = 500;
    
    //instance variables 
    private boolean active;

    /**
     * Constructor for objects of subclass MoneyMarket
     */
    public MoneyMarket(String id,double bal)
    {
        // initializes instance variables
        super(id, bal);
        setAccountStatus(); //sets the account status based on the balance
        
    }
     /**
     * setAccountStatus method sets the account status based on the balance
     * 
     */
     
    private void setAccountStatus() {
        if (super.getBalance() > minBalance)        //checks if balance is greater than the minimum balance
        {
            active = true;
        }
        else
        {
            active = false;
        }
    }
    /**
     * withdraw method checks if the account is active and withdraws the input amount if active.  If not active displays an error.
     * 
     * @param amount  a parameter for the withdrawl amount in dollars 
     */

    public void withdraw(double amount )
    {
        if (!active)        //displays error if account is not active
        {
            System.out.println("MoneyMarket " + super .getAccountID()+ ": Withdrawl not allowed");
        }
        else
        {
            super.withdraw(amount);     //withdraws the input amount
            setAccountStatus();         //updates the status of the account
        }  
    }
    /**
     * deposit method increases the balance of the account by the deposit amount and updates the account status.
     * 
     * @param  depositAmount    a parameter for the deposit amount in dollars 
     */
    public void deposit(double depositAmount)
    {
        super.deposit(depositAmount);   //deposits input amount
        setAccountStatus();             //updates the status of the account
    }
     /**
     * printMonthEnd method adds a monthly service charge, updates the accoutn status, and displays 
     * a report of all account activity using the printMonthEnd superclass method
     * 
     */
    public void printMonthEnd()
    {
        if (!active)            //imposes a $5 service fee if account is not active
        {
            super.setServiceCharge(super.getServiceCharge()+ minBalanceFee);
        }
       
        super.printMonthEnd();  //call printMonthEnd from checking(superclass)
        setAccountStatus();     //update the status of the account
      
        if (active)             //outputs the status of the account
        {
            System.out.println("\nMoney market account is: active" );
        }else{
            System.out.println("\nMoney market account is: inactive" );
        }
    }
     /**
     * Genarates tostring method to return a String that represents the MoneyMarket object
     * by calling sharingString from superclass (checking)
     * 
     * @return  a String that represents the MoneyMarket object
     */

    public String toString()
    {
        return "MoneyMarket" + super.accountString()+ "[active=" + active + "]";
       
    }
}

