package algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindCommonElement {
    public static void main (String[] args){
        String arr1[] = {"Hello", "World","From","Mexico"};
        String arr2[] = {"Hi", "I", "Am","From", "Mexico"};
        findElements(arr1,arr2);
    }

    private static void findElements(String arr1[], String arr2[]){

        Set data1 = new HashSet();
        Set data2 = new HashSet();

        for(int x = 0; x < arr1.length; x++){
            data1.add(arr1[x]);
        }

        for(int x = 0; x < arr2.length; x++){
            data2.add(arr2[x]);
        }

        data1.retainAll(data2);

        System.out.println(data1);
    }
}
