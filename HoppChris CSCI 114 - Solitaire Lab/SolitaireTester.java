/**
 * Tests Solitaire.
 * 
 * @author Anthony W. Smith
 * @version 5/31/2028
 */
public class SolitaireTester
{
    public static void main(String[] args)
    {
        Solitaire s = new Solitaire();

        System.out.println("Start: " + s.toString());

        int rounds = 0;
        while (s.over() == false) {
            s.round();
            ++rounds;
            System.out.println(rounds + ": " + s.toString());
        }
        System.out.println("Rounds: " + rounds);
    }
}
