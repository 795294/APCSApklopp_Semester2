//© A+ Computer Science
// www.apluscompsci.com

//Monster example

import static java.lang.System.*;
import java.util.Scanner;

public abstract class Monster
{
   private String name;
   private static int count = 0;

   public Monster()
   {
      name="";
      count++;
   }

   public Monster(String nm)
   {
   	name = nm;
   	count++;
   }

   public String getName()
   {
   	return name;
   }

   public abstract String talk( ); //talk is declared abstractly so each monster says a different thing

   public String toString() {
      return name + "  says  " + talk();
   }
}

