package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArrayElementsBySign {
    public static void main(String... ab){

        int n = 6;
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5, 3, 4));

        ArrayList<Integer> ans = getRearrangeBySign(A, n);

        for (Integer an : ans) {
            System.out.print(an + " ");
        }

    }

    public static ArrayList<Integer> getRearrangeBySign(ArrayList<Integer> A, int n) {
        List<Integer> posList = new ArrayList<Integer>();
        List<Integer> negList = new ArrayList<Integer>();

        for(int i = 0; i< n; i++){
            if(A.get(i) < 0)
                negList.add(A.get(i));
            else
                posList.add(A.get(i));
        }
        int posI = 0;
        int negI = 0;
        for(int i = 0; i< n; i++){

            if(posI < posList.size() && (i%2 == 0)) {
                A.set(i, (Integer) posList.get(posI));
                ++posI;
            }
            if(negI < negList.size() && (i % 2 == 1)){
                A.set(i , (Integer) negList.get(negI));
                ++negI;
            }
        }

        return A;
    }
}
