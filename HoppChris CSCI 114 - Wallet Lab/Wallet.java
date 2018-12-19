import java.util.ArrayList;
/**
 * Wallet class creates a wallet containing banknotes and counts and organizes those bills
 * 
 * @author Chris Hopp
 * @version 11/13/16
 */
public class Wallet
{
    // max possible number of banknotes in a wallet
    private static final int MAX = 10;

    private int contents[];
    private int count; // counts number of banknotes stored in contents[]

  
    public Wallet()                     //Constructs an empty wallet
    {
        contents = new int[MAX]; 
        count = 0;
    }
    public Wallet(int a[])              //initializes a new wallet with an array for banknotes
    {
        contents = a;
        count=a.length;

    }
    public String toString()            //returns wallet information in the form of a string
    {
        if(count == 0)                  //if wallet is empty, returns an empty set
            return "[]";

        StringBuffer s = new StringBuffer("["); 
        int i;
        for(i = 0; i < count-1; i++)
            s.append(contents[i] + ", ");
        s.append(contents[i] + "]");

        return s.toString();            //returns contents of wallet
    } 
    public int value()                  //calculates and returns the total value of the wallet
    {                       
        int total = 0;
        for(int i = 0; i < count; i++){
            total+=contents[i];
        }
        return total;
    }
    public void add (int banknote)      //adds banknote to end of wallet and increases count
    {
        contents[count] = banknote;
        count ++;
    }
    public void transfer(Wallet donor){ //transfers contents of wallet into new wallet

        for(int i = 0; i < donor.count; i++){
            add(donor.contents[i]);
        }
        donor.count = 0;

    }
    public boolean remove(int banknote) //removes first occurance of a banknote
    {

        for (int i=0; i < count; i++) {

            if (contents[i] == banknote) {
                for(int x=i+1; x<count; x++) {
                    contents[x-1] = contents[x]; 
                }
                count--;
                return true ;           //returns true if note removed
            }
        }
        return false;                   //returns false if no note removed
    }
    public boolean sameBanknotesSameOrder(Wallet other)
    {                           //compares two wallets to see if contents are the same in the same orde
        if (other.count != count) {
            return false;
        }
        else {
        for(int i = 0; i < count; i++) {
            if(contents[i] != other.contents[i]) {
                return false;
            }
        }
        return true;
        }
    }
    public Wallet removeBanknotePairs(Wallet w){        //compares two wallets and removes pairs of banknotes
                                                        //somehow does not check first element or does not properly remove pair of $20s 
        Wallet w3 = new Wallet();
        int i,x,y,z;

        for ( i=0; i < count; i++) {
            for(x=0; x < w.count; x++){

                if (contents[i] == w.contents[x]) {      //checks for pairs between the wallets
                    w3.add(contents[i]);                // adds pair to wallet 3
                    w3.add(w.contents[x]);

                    for(y=i+1; y < count; y++) {        //removes from wallet and adjusts count
                        contents[y-1] = contents[y];
                    }
                    count--;
                    

                    for(z=x+1; z < w.count; z++) {      //removes from other wallet and adjusts count
                        w.contents[z-1] = w.contents[z];

                    }
                    
                    w.count--; 

                }

            }
        }    
        return w3;}                                     //returns new wallet with pairs 

}

