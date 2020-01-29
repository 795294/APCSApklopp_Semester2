
/**
 * Write a description of class LiteratureCelebrity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LiteratureCelebrity extends Celebrity
{
    private String book; //book which they wrote 

    public LiteratureCelebrity(String answer, String clue)
    {
        super(answer, clue.substring(clue.indexOf(",")+1));
        this.book = clue.substring(0,clue.indexOf(","));
    }

    public String getClue() 
    {
        if(Math.random()<0.2)
            return "Wrote " + book;
        return super.getClue();
    }

    public String toString() 
    {
        return super.toString() + ", and this person wrote " + book;
    }

    public void setBook(String book) 
    {
        this.book = book;
    }

    public String getBook() 
    {
        return book;
    }

}
