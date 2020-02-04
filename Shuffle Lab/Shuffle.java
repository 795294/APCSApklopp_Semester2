
/**
 * Shuffles a deck of cards
 *
 * @author (Peter Klopp)
 * @version (Lab204)
 */
import java.util.*;

public class Shuffle
{

    public Shuffle(int[] s)
    {
        ArrayList<Integer> s2 = new ArrayList<Integer>();
        
        for(int i = 0; i< s.length; i++){
            if((int)(Math.random()*2) == 1){
                s2.add(s[i]);
            } else {
                s2.add(s[s.length-i-1]);
            }
            
        }
        
        System.out.println();
        
        for(int i = 0; i< s2.size(); i++){
            
            System.out.print(s2.get(i) + ", ");
        }
    }

    public static void main()
    {
        int[] nums = new int[52];

        for(int i = 0; i < 52; i++){
            nums[i] = i+1;
        }

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + ", ");
        }

        Shuffle s = new Shuffle(nums);
    }
}
