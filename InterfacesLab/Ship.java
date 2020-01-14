//© A+ Computer Science
// www.apluscompsci.com

//interface example

public class Ship implements Locatable, Movable
{
    private int xPos, yPos;

    public Ship()
    {
        xPos=yPos=0;
    }

    public Ship(int x, int y)
    {
        xPos=x;
        yPos=y;
    }

    
    //add set methods - use Movable interface
    public void setPos(int x, int y){
       xPos=x;
       yPos=y;
    }
    public void setX(int x){
        xPos=x;
    }
    public void setY(int y){
        yPos=y;
    }
    //add get methods - use Locatable interface
    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }

    

    public boolean equals(Object obj)
    {
       Ship other = (Ship)obj;
       if(xPos==other.xPos&&yPos==other.yPos)
          return true;
       return false;    
    }
    
    public String toString()
    {
        return " "+xPos+" "+yPos;
    }
}