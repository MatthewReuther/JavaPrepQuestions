package org.example.Arrays;


//Complexity Analysis
//Time Complexity: O(N), since we only have 2 pointers, and both the pointers will traverse the array at most once.
//Space Complexity: O(1), since we are not using any extra space.

class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        //used to keep track of the position in the nums array where the next unique element should be placed.
        int currIndexCount = 0;

        // iterates over each element in the nums array.
        for (int i = 0; i < nums.length; i++) {

            //check if element is not last element in the array and
            //if the element is equal to the element that comes after it in array
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                //If both true, element is duplicate of next element and the loop skips over
                continue;
            }

            //is not a duplicate, then it is added to the nums array at the position indicated by currIndex.
            nums[currIndexCount] = nums[i];
            //incremented by 1 to prepare for the next unique element.
            currIndexCount++;
        }
        //returns the final value of currIndex
        //length of the array with duplicates removed.
        return currIndexCount;
    }
}


