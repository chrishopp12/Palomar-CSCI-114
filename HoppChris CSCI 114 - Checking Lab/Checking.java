
/**
 * Checking superclass creates a checking account that tracks balance, deposits, withdrawls, service charges, and the active/ inactive status of the account.
 * 
 * @author Chris Hopp
 * @version 12/4/2016
 */
public class Checking
{
    // static constants for set fee amounts
    private static final int depositFee = 50;  
    private static final int withdrawFee = 25;

    
    // instance variables
    private String accountID;       //an identifying account number
    private int balance;            //balance of the account in pennies
    private int numDeposits;        //number of deposits made
    private int numWithdrawls;      //number of withdrawls made
    private int serviceCharge;      //maintain the total monthly service charges incurred here, in pennies

    /**
     * Constructor for objects of superclass Checking
     */
    public Checking(String id, double bal)
    {  //initializes instance variables
        accountID = id;
        balance = (int) Math.round(bal * 100.0); //converts the dollar starting balance parameter bal to cents
        numDeposits = 0 ;
        numWithdrawls = 0;
        serviceCharge = 0;
    }
    /**
     * deposit method increases the balance of the account by the amount of the deposit and adds a $.25 deposit fee.
     * 
     * @param  depositAmount   parameter for a deposit amount in dollars
     */
    public void deposit(double depositAmount)
    {
        balance+= (int) Math.round(depositAmount*100.0); //converts deposit amount to pennies and adds to balance
        numDeposits++;                                   //increases the number of deposits
        serviceCharge += depositFee;                     //increases the service charge amount by a deposit fee ($.25)

    }
    /**
     *  withdraw method decreases the balance of the account by the amount of the withdrawl and adds a $.25 withdrawl fee on the first two withdrawls and a $1.00
     *  withdrawl fee on all subsequent withdrawls
     * 
     * @param  withdrawlAmount   a parameter for a withdrawl amount in dollars 
     */

    public void withdraw( double amount)
    {
        balance -= (int) Math.round(amount*100.0); //converts withdrawl amount to pennies and subtracts from balance
        numWithdrawls++;                           //increases the number of withdrawls

        if (numWithdrawls < 3)
        {
            serviceCharge += withdrawFee;           //increases the service charge amount by a withdrawl fee ($.25)
        } 
        else{
            serviceCharge += (4 * withdrawFee);    //increases the service charge amount by a withdrawl fee($1.00)
        }
    }
    /**
     *  printMonthEnd method displays a report of all account activity during the month and resets the number of withdrawls, deposits, and service charges
     *  
     */

    public void printMonthEnd()
    {
        balance-= serviceCharge;                                                                //decreases by balance by accumulated service charge amount
        System.out.println("Account ID " +accountID);                                           //displays account ID
        System.out.printf("Balance is: $%.2f\n", balance/100.0 );                               //displays balance converted to dollars
        System.out.println(numDeposits +" deposits, "+numWithdrawls +" withdrawls");            //displays number of deposits and withdrawls
        System.out.printf("Monthly service charge was: $%.2f", serviceCharge/100.0);            //displays mothly service charge converted to dollars
        
        numWithdrawls = 0;  //resets the number of deposits, withdrawals, and monthly service charge to zero
        serviceCharge = 0;  
        numDeposits = 0;

    }
    /**
     * public method account string can be used to create a string in super and subclass
     * 
     * @return  the account string
     */

    public String accountString() {
        
        return"[accountID=" +accountID +", "+"balance=" + balance +", "+"numDeposits=" + numDeposits +", " 
        +"numWithdrawls="+ numWithdrawls +", "+"serviceCharge="+ serviceCharge +"]";
    }
    /**
     * return a String that represents the Checking object by calling shareString method
     *
     * @return the checking account string
     */

    public String toString() {
        
        return"Checking"+accountString();
    }
    /**
     * 
     *get and set methods for balance, service charge, and account ID to be used in super and subclasses
     *  
     */

    public int getBalance()
    {
        return balance;
    }
    public void setBalance(double bal)
    {
        balance = (int) Math.round(bal*100.0);
    } 
    public int getServiceCharge()
    {
        return serviceCharge;
    }
    public void setServiceCharge(int newFee)
    {
        serviceCharge = newFee;
    }
    public String getAccountID()
    {
        return accountID;
    }
}
