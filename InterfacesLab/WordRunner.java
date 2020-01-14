//© A+ Computer Science
// www.apluscompsci.com

//comparable example one

import static java.lang.System.*;
import java.util.*;

public class WordRunner
{
    public static void main ( String[] args )
    {
        Word x = new Word("dog");
        Word y = new Word("cat");
        System.out.println( x.compareTo(y) );

        Word[] wl = new Word[5];
        wl[0] = new Word("john");
        wl[1] = new Word("joe");
        wl[2] = new Word("steve");
        wl[3] = new Word("bill");
        wl[4] = new Word("dan");
        
        Arrays.sort(wl);
        
        for(int i = 0; i < wl.length; i++){
            System.out.print(wl[i] + ", ");
        }
        //make a list of Word
        //call Collections.sort() and sort the list
        //print the list
    }
}