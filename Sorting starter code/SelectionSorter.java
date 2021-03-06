 


/**
 * Write a description of class SelectionSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
  

public class SelectionSorter extends Sorter
{

    public SelectionSorter() {
        super();
    }

    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            swap(a, minIndex, i);
        }
    }

}
