
/**
 * Reverse an arraylist and an array
 *
 * @author (Peter Klopp)
 * @version (108)
 */
import java.util.*;

public class RevList
{
    
    public RevList(String[] revArr, ArrayList<String> revList){
        revArr[0] = "sam";
        revArr[1] = "steve";
        revArr[2] = "joe";
        revArr[3] = "jffh";
        revArr[4] = "sjfhh";
        
        revList.add("sam");
        revList.add("djsg");
        revList.add("sdlk");
        revList.add("wopq");
        revList.add("q;pdo");
    }
    
    public ArrayList<String> reverseList(ArrayList<String>  list){
        ArrayList<String> temp = new ArrayList<String>();
        
        for(int i = 0; i<list.size(); i++){
            temp.add(list.get(list.size()-1-i));
        }
        
        return temp;
    }

 

    public String[] reverseArr(String[]  list){
        String[] temp = new String[list.length];
        
        for(int i = 0; i<list.length; i++){
            temp[i] = list[list.length-1-i];
        }
        
        return temp;
    }
    
    public static void main(){
        String[] revArr = new String[5];
        ArrayList<String> revList = new ArrayList<String>();
        
        RevList rl = new RevList(revArr, revList);
        
        System.out.println(rl.reverseList(revList));
        System.out.println(rl.reverseArr(revArr));
    }
}
