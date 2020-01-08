
/**
 * Testing to see how Java makes constructors
 *
 * @author (Peter Klopp)
 * @version (1/8/2020)
 */
public class Pumpkin
{
    private int id;
    private double weight;
    
    public Pumpkin(int x, double y)
    {
        id = x;
        weight = y;
    }

    
    public static void main(){
        Pumpkin p = new Pumpkin(5, 5.0);
    }
}
