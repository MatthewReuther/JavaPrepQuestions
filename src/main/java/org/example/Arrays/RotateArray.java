package org.example.Arrays;

import java.util.Arrays;

//Modulos (%) returns the remainder of a division
public class RotateArray {

    //Complexity
    //The time complexity of this function is O(n), where n is the length of the array, because it involves two loops that each iterate over the elements of the array.
    //The space complexity is also O(n), because it requires a temporary array to store the rotated version of the original array.
    public void rotate(int[] nums, int k) {

        //create a new array that has same length as the original array
        int[] rotatedArray = new int[nums.length];

        //assign the elements of the original array to the new array,
        for (int i = 0; i < nums.length; i++) {

            //using the formula (i + k) % nums.length to determine the new position of each element.
            //modulo operator % is used to ensure that the index stays within the bounds of the array, even if k is larger than the length of the array.
            rotatedArray[(i + k) % nums.length] = nums[i];
        }

        // copy the elements of the rotated array back to the original array.
        for (int i = 0; i< nums.length; i++) {
            nums[i] = rotatedArray[i];
        }

        System.out.println(Arrays.toString(rotatedArray));
    }


}



