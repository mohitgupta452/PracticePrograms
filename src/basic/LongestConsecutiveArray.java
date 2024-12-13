package basic;

import java.util.*;

public class LongestConsecutiveArray {
    public static int longestSuccessiveElements(int[] a) {
        int n = a.length;
        if (n == 0) return 0;

        //sort the array:
        Arrays.sort(a);
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;

        //find longest sequence:
        for (int i = 0; i < n; i++) {
            if (a[i] - 1 == lastSmaller) {
                //a[i] is the next element of the
                //current sequence.
                cnt += 1;
                lastSmaller = a[i];
            } else if (a[i] != lastSmaller) {
                cnt = 1;
                lastSmaller = a[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    static int longestArray(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        int maxCount = count;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i + 1] - arr[i]) == 1) {
                ++count;
            } else
                count = 1;

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    static int longestArrayUsingSet(int[] arr) {
        int count = 1;
        int maxCount = count;
        Set<Integer> set = new TreeSet<>();
        for (int ele : arr) {
            set.add(ele);
        }

        for (int ele : set) {
            if (set.contains(ele + 1)) {
                ++count;
            } else
                count = 1;

            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int[] b = {3, 8, 5, 7, 6};
        int[] c = {11, 39, 13, 10, 14, 20, 12, 15};
        int[] d = {136, 141, 156, 135, 144, 133, 134, 192, 143, 132, 142};
//        int ans = longestSuccessiveElements(a);
//        int ans = longestArray(d);
        int ans = longestArrayUsingSet(d);

        System.out.println("The longest consecutive sequence is " + ans);
    }


}

