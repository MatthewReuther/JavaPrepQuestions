package org.example.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


//PROBLEM//
//Given two arrays, write a function to compute their intersection.
//Each element in the result should appear as many times as it shows in both arrays.
//The result can be in any order.

//Follow-Up Questions
//What if the given array is already sorted? How would you optimize your algorithm?
    //Solution 1, i.e., sorting, would be better since it does not need extra memory.

//What if nums1’s size is small compared to num2’s size? Which algorithm is better?
    //If two arrays are sorted, we could use binary search, i.e., for each element in the shorter array, search in the longer one.
    //So the overall time complexity is O(nlogm), where n is the length of the shorter array, and m is the length of the longer array.
    //Note that this is better than Solution 1 since the time complexity is O(n + m) in the worst case.

//What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
    //If the two arrays have relatively the same length, we can use external sort to sort out the two arrays in the disk.
    //Then load chunks of each array into the memory and compare, by using the method 1.

    //If one array is too short while the other is long, in this case, if memory is limited and nums2 is stored in disk, partition it and send portions of nums2 piece by piece.
    //keep a pointer for nums1 indicating the current position, and it should be working fine~

    //Another method is, store the larger array into disk, and for each element in the shorter array, use “Exponential Search” and search in the longer array.

public class IntersectionOfTwoArrays {

    /**
     * Overall time complexity is bounded by O(n logn), where n is the length of the longer array. The main body of the loop is bounded by O(m + n).
     * @param nums1 int array list 1
     * @param nums2 int array list 2
     * @return  return intersection of the two given arrays
     */

    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        //Used to iterate through nums1 and nums2, respectively
        int nums1Index = 0;
        int nums2Index = 0;

        List<Integer> intersectList = new ArrayList<>();

        //continues until either i reaches the end of nums1 or j reaches the end of nums2
        while(nums1Index < nums1.length && nums2Index < nums2.length) {

            //if the elements at index nums1Index in nums1 and index nums2Index in nums2 are equal
            if (nums1[nums1Index] == nums2[nums2Index]) {
                //add the element to the intersectList
                intersectList.add(nums1[nums1Index]);
                //increments both nums1Index and nums2Index
                nums1Index++;
                nums2Index++;

                //If the element in nums1 is smaller, increment nums1Index
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                nums1Index++;
                //If the element in nums2 is smaller, increment nums2Index
            } else {
                nums2Index++;
            }
        }

        return listToArrHelper(intersectList);
    }

    /**
     * The overall complexity of this function is O(n + m), where n is the length of nums1 and m is the length of nums2.
     *
     * Iterates through nums1 and adds each element to a HashMap, which takes O(n) time.
     * Then, it iterates through nums2 and adds each element to a List if it is in the HashMap and its frequency is greater than 0, which also takes O(m) time.
     * Converts the List to an array using the listToArrHelper function, which takes O(m) time.
     * @param nums1 int array list 1
     * @param nums2 int array list 2
     * @return  return intersection of the two given arrays
     */
    public int[] intersect2(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> compareMap = new HashMap<>();
        //iterates through nums1, adding each element to the map as a key and its frequency as the value.
        for (int number : nums1) {
            if (compareMap.containsKey(number)) {
                //if map already contains key add 1 to the vaule
                compareMap.put(number, compareMap.get(number) + 1);
            } else {
                //add number to map with count 1 as value
                compareMap.put(number, 1);
            }
        }

        //Create new Arr List of in Integers
        List<Integer> intersectList = new ArrayList<>();

        //For each element in nums2, the function adds the element to the result list and decrements its frequency in the map.
        for (int number : nums2) {
            //if the element is in map and its frequency is greater than 0
            if (compareMap.containsKey(number) && compareMap.get(number) > 0 ) {
                //add the element to the intersectList list
                intersectList.add(number);
                int mapNumFreq = compareMap.get(number);
                //decrements its frequency in the map
                mapNumFreq--;
                //add decremented frequency to map
                compareMap.put(number, mapNumFreq);
            }
        }

        return listToArrHelper(intersectList);
    }

    /**
     * Creates a new array of integers with the same size as the input list,
     * and copies the elements from the list to the array. It then returns the array.
     * @param integerList list of integers needing to be converted to array
     * @return array of integers
     */
    private int[] listToArrHelper(List<Integer> integerList) {

        int[] listToArr = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            //assign the element at index i in the List
            //to the element at index i in the array
            listToArr[i] = integerList.get(i);
        }
        return listToArr;
    }
}
