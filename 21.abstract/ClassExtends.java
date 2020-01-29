//© A+ Computer Science  -  www.apluscompsci.com

//inheritance example

import static java.lang.System.*;
import java.util.Scanner;

class A
{
	void fun()
	{
	}
}

class B
{
	void notFun()
	{
	}
}

class C
{
	void weird()
	{
	}
}

class D extends A,B   //no can do
{

}//java does not allow you to extend multiple classes,but multiple interfaces can be implemented in the same class

public class ClassExtends
{
  public static void main ( String[] args )
  {
  }
}