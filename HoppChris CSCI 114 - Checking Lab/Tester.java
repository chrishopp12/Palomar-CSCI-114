import java.util.ArrayList;

/**
 * Driver for Lab 5 Inheritance
 * 
 * @author Anthony W. Smith
 * @version 5/31/2028
 */
public class Tester
{
    public static void main(String arg[])
    {
        // create some accounts
        Checking check = new Checking("123", 100.0); // $100.00 balance
        MoneyMarket money = new MoneyMarket("456", 1000.0);  // $1000.00 balance
        ArrayList<Checking> accounts = new ArrayList<>();
        accounts.add(check);
        accounts.add(money);
        
        // do some transactions
        System.out.println("Transactions");
        // on Checking object
        check.deposit(750.0);
        check.withdraw(12.0);
        check.withdraw(34.0);
        check.withdraw(56.0);

        // on MoneyMarket object
        money.withdraw(750.0);
        money.withdraw(100.0);
        money.deposit(50.0);

        // print accounts
        System.out.println("\nPrint accounts");
        for (Checking c : accounts)
            System.out.println(c.toString());
        
        // print month end report
        System.out.println("\nMonth end report");
        for (Checking c : accounts) {
            c.printMonthEnd();
            System.out.println();
        }
    }
}
