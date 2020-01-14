//© A+ Computer Science
// www.apluscompsci.com

//generic comparable example

public class Word implements Comparable<Word>
{
  private String orig;

  public Word(String s) { orig = s; };

  public int compareTo(Word other) 
  {

     //must add code to complete 
     
     Word object = (Word)other;
     if(orig.length() < object.orig.length()){
        return -1;
     }else if(orig.length() == object.orig.length()){
        return 0;
     }
     return 1; 
     
  }

  public String toString() { return orig; }
}
