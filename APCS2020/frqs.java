
/**
 * Write a description of class frqs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class frqs
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class frqs
     */
    public frqs()
    {
        // initialise instance variables

    }

    //APID: 
    //PK 
    //Part a:
    public int countElectronicsByMaker(String maker){
        int count = 0;

        for(int i = 0; i < purchases.size(); i++){
            if(maker.equals(purchases.get(i).getMaker()) && purchases.get(i).isElectronic()){
                count++;
            }
        }

        return count;
    }

    public boolean hasAdjacentEqualPair(){
        for(int i = 0; i < purchases.size(); i++){
            if(purchases.get(i).equals(purchases.get(i+1))){
                return true;
            }
        }

        return false;
    }

    public Gizmo getCheapestGizmoByMaker(String maker){
        /*Sample response: The method header should be public Gizmo getCheapestGizmoByMaker( String mkr ).
        The Gizmo class will need a new instance varible to store the cost for each Gizmo
        which suggests the Gizmo class will also need a constructor to recieve a cost value
        as well as a public method that will return the cost of a Gizmo.
        The new private double cost instance variable would store the cost of each Gizmo
        allowing the new getCheapestGizmoByMaker method to determine the cost of each Gizmo.  */ 
    }
    
    public static boolean isValid(int numWithCheckDigit){
        //the check digit is always the right most
        int checkDigit = numWithCkeckDigit%10;
        int num = numWithCkechDigit/10;
        if(getCheck(num) == checkDigit){
            return true;
        }
        
        return false;
    }
    //Part B
    /*Make a new class variable named count of type int  -- private static int count = 0;
     * The new count variable would be increased by one in the isValid method for each getCheck 
     * call that returns a value that does not match the right most digit of the numWithCheckDigit value.
     * The rightmost digit of numWithCheckDigit is accessed using % 10.
     * 
     */
    
    //APID: 510XY720
    //Initials: PK
    //AP Coumputer Science A, Question 1
    //Part A
    public void addNewSitters(String[] names){
        for(int i = 0; i<names.lenght; i++){
            if(sitterList.get(i) == names[i]){
                return;
            } else {
                sitterList.add(new BabySitter(names[i], 0);
            }
        }
    }
    
    //Part B
    
    public ArrayList<BabySitter> affordableSitters(double budget, int numChildren, int hours){
        int amountCharged;
        ArrayList<BabySitter> returnList = new ArrayList<BabySitter>;
        
        for(int i = 0, i < sitterList.size(); i++){
            if(sitterList.get(i).getYears() == 0){
                amountCharged = 2*numChildren*hours;
            } else if(sitterList.get(i).getYears() > 0 && sitterList.get(i).getYears() < 4){
                amountCharged = 2*sitterList.get(i).getYears*numChildren*hours;
            } else if(sitterList.get(i).getYears() == 4){
                amountCharged = 6*numChildren*hours;
            }
            
            if(amountCharged <= double budget){
                returnList.add(sitterList.get(i));
            }
            
            
        }
        
        retrun returnList;
        
    }
    
    //Part C
    
    //The method header for getHighDemandSitters should be public ArrayList<BabySitter> getHighDemandSitters(String names[]).
    //The BabySitter class would need a new instance variable to store the demand for each BabySitter. 
    //This suggests that the constructor of the BabySitter class should also initialize this value. There will then need
    //to be a public method in the BabySitter class which would return the demand of the BabySitter. getHighDemandBabySitters would
    //then be able to get through each name in names[] and return the value of the demand instance variable.
    
    
    //APID: 510XY720
    //Initials: PK
    //AP Coumputer Science A, Question 2
    //Part A
    
    public static double checkGuesses(String phrase, int num){
        int count = 0;
        String guess = "";
        for(int i = 0; i<num; i++){
            guess = getGuess();
            
            for(int j = 0; j < phrase.length(); i++){
            
                if(guess.equals(phrase.substring(i, guess.length()))){
                    count++;
                }
            }
        }
        
        return count/num;
        
    }
    
    //Part B
    
    I would make a new instance variable named numGuesses of type int (private int numGuesses)
    In a StringGuess constructor, I would initialize this value to (int)(Math.random()*100)+1. I would then
    pass in numGuesses as a parameter to each call of checkGuesses.
    

}
