
/**
 * Sorts an ArrayList of numbers using different algorithms
 *
 * @author (Peter Klopp)
 * @version (Lab1024 - SortTester)
 */
import java.util.*;

public class SortTester
{

    public void loadNumbers(ArrayList<Integer> n, int x){
        for(int i = 0; i<x; i++){

            int rand = (int)(Math.random()*1000);

            n.add(rand);

            System.out.print(n.get(i)+",");
        }
    }

    public void bubbleSort(ArrayList<Integer> n)  
    {  
        System.out.println("\nBubble Sorted list: ");

        for(int i= n.size(); i>=0; i--){
            for(int j = 0; j<i ;j++){
                if(j < i-1){
                    if(n.get(j) > n.get(j+1)){
                        int temp = n.get(j+1);

                        n.set(j+1, n.get(j));

                        n.set(j,temp);
                    }
                }
            }
        }

        for(int i = 0; i<n.size(); i++){
            System.out.print(n.get(i) + ",");
        }
    } 

    public void insertSort(ArrayList<Integer> n){
        System.out.println("\nInsertion Sorted list: ");
        for(int i = 1; i < n.size(); i++){
            int j = i;
            while((j>0) && n.get(j) < n.get(j-1)){
                int temp = n.get(j-1);

                n.set(j-1, n.get(j));

                n.set(j,temp); 

                j = j-1;
            }

        }

        for(int i = 0; i<n.size(); i++){
            System.out.print(n.get(i) + ",");
        }
    }

    public void selectSort(ArrayList<Integer> n){
        System.out.println("\nSelection Sorted list: ");
        for(int i = 0; i < n.size()-1; i++){
            int minNum = i;

            for(int j = i+1; j < n.size(); j++){
                if(n.get(j)<n.get(minNum)){
                    minNum = j;
                }
            }

            int smallestNumber = n.get(minNum);

            n.set(minNum, n.get(i));

            n.set(i, smallestNumber);

        }

        for(int i = 0; i<n.size(); i++){
            System.out.print(n.get(i) + ",");
        }
    }

    public void mergeSort(ArrayList<Integer> n){
        if(n.size()<2){
            return;
        }

        int mid = n.size()/2;

        ArrayList<Integer> l = new ArrayList<Integer>(mid);
        ArrayList<Integer> r = new ArrayList<Integer>(n.size()-mid);

        for(int i = 0; i < mid; i++){
            l.add(n.get(i));
        }
        for(int i = mid; i < n.size(); i++){
            r.add(n.get(i));
        }

        mergeSort(l);
        mergeSort(r);
        merge(n, l, r, mid, n.size()- mid);
    }

    public void merge(ArrayList<Integer> n, ArrayList<Integer> l, ArrayList<Integer> r, int left, int right){
        int i = 0, j = 0;
        while(i < left && j < right){
            if(l.get(i) <= r.get(j)){
                n.add(l.get(i++));;
            }else{
                n.add(r.get(j++));
            }
        }
        while(i < left){
            n.add(l.get(i++));
        }
        while(j < right){
            n.add(r.get(j++));
        }
    }

    public static void main(){
        ArrayList<Integer> numList = new ArrayList<Integer>();

        SortTester sort = new SortTester();

        sort.loadNumbers(numList, 1000);

        sort.bubbleSort(numList);

        sort.insertSort(numList);

        sort.selectSort(numList);
        
        sort.mergeSort(numList);

    }

}