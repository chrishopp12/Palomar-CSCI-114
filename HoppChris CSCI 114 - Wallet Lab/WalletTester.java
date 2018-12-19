/**
 * Test the Wallet class.
 * 
 * @author Anthony W. Smith
 * @version 5/31/2028
 */
public class WalletTester
{
    public static void main(String args[])
    {
        // create a new Wallet object using an array
        int a[] = {5, 50, 10, 5};
        Wallet myWallet = new Wallet(a);
        
        // show the contents of myWallet
        System.out.println("myWallet contains: " + myWallet.toString());
        
        // print the value of myWallet
        System.out.println("\nvalue of myWallet is: $" + myWallet.value());
        
        // transfer all the banknotes from myWallet to yourWallet!
        Wallet yourWallet = new Wallet();
        yourWallet.add(1);
        yourWallet.transfer(myWallet);
        System.out.println("\nnow myWallet contains: "
                                                 + myWallet.toString());
        System.out.println("yourWallet contains: "
                                               + yourWallet.toString());

        // remove all $5 banknotes from yourWallet
        while (yourWallet.remove(5))
            ;
        System.out.println("\nyourWallet with $5s removed is: "
                                               + yourWallet.toString());
        
        // check whether two wallets have the same banknotes
        // in the same order
        int b[] = {10, 5, 10};
        Wallet tom = new Wallet(b);

        int c[] = {10, 5, 10, 1};
        Wallet dick = new Wallet(c);

        int d[] = {10, 5, 10};
        Wallet harry = new Wallet(d);
        
        System.out.println(
             "\ntom has same banknotes in same order as dick: "
                                    + tom.sameBanknotesSameOrder(dick));
        System.out.println(
            "tom has same banknotes in same order as harry: "
                                   + tom.sameBanknotesSameOrder(harry));
        
        // EXTRA CREDIT – compare two wallets and remove banknote pairs
        int e[] = {5, 1, 50, 20, 50, 5};
        Wallet w1 = new Wallet(e);

        int f[] = {20, 10, 5, 5, 5, 50, 10};
        Wallet w2 = new Wallet(f);

        Wallet w3 = w1.removeBanknotePairs(w2);
        System.out.println("\nw1 is: " + w1.toString());
        System.out.println("w2 is: " + w2.toString());
        System.out.println("w3 is: " + w3.toString());
    }
}
