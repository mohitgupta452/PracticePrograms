package basic;

import java.util.ArrayList;
import java.util.List;

public class LeadersArray {
    public static void main(String... ab) {
        int[] arr = new int[]{10, 22, 12, 3, 0, 6};
        List<Integer> leadersList = getLeaders(arr);
        System.out.println(leadersList);
    }

    public static List<Integer> getLeaders(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int max = arr[arr.length - 1];
        list.add(max);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                list.add(arr[i]);
                max = arr[i];
            }
        }
        return list;
    }
}
