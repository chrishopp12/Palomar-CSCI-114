import java.util.ArrayList;
/**
 * Solitaire class creates a random grouping of piles of cards up to a total of 45 cards and then
 * removes one card from each pile creating a new pile of cards until piles of 1-9 cards are formed.
 * 
 * @author Chris Hopp
 * @version 10/23/16
 */
public class Solitaire
{
    private ArrayList<Integer> piles;                //Variable for an array list of piles

   public Solitaire()                               //Constructs piles
    {   
      piles = new ArrayList<>();
      
      int p = 1;
      int sum = 0;

      while (p==1){
       int num = (int) (Math.random() * (45 - sum)+1);      //Random number of cards less than the total cards availble
       if (num + sum <= 45){
           sum = sum + num;
           piles.add(num);
        } 
       if (sum==45){                                //Creates piles up to a max 45 cards
           p=0;
        }              
      }
    }
   public String toString()
    {
        return piles.toString();        //returns array list of piles to a string format
    }
   public boolean over()               //checks if game is complete
    {   
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);                 //creates an array list of required numbers
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        
       for (int i=0; i<piles.size();++i)
       {int x = piles.get(i);
       if (numbers.indexOf(x)!= -1) {              //checks if number of cards matches required number of cards
          int y = numbers.indexOf(x);
          numbers.remove(y);
          --i;
        }  
        }
       if (numbers.size() == 0){       //checks if all required numbers have been used
            return true;
        }
        else
        {
            return false;
        }
    }
   public void round()                          //completes one round of the game
    { 
       piles.add(piles.size());                 //creates a pile of all the cards removed               
       int i = 0;
       while (i < piles.size()-1){
            int x = piles.get(i)-1;
            if (x == 0){
                piles.remove(i);             //removes entire pile if only one card
            }
            else {
                piles.set(i, x);            //removes one card from each pile
                ++i;
            }
       } 
   }
}
    
   




